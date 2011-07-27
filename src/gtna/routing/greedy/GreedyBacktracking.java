/* ===========================================================
 * GTNA : Graph-Theoretic Network Analyzer
 * ===========================================================
 *
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors
 *
 * Project Info:  http://www.p2p.tu-darmstadt.de/research/gtna/
 *
 * GTNA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GTNA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * ---------------------------------------
 * GreedyBacktracking.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: "Benjamin Schiller";
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 * 2011-06-06 : v1 (BS)
 *
 */
package gtna.routing.greedy;

import gtna.graph.Node;
import gtna.routing.Route;
import gtna.routing.RouteImpl;
import gtna.routing.RoutingAlgorithm;
import gtna.routing.RoutingAlgorithmImpl;
import gtna.routing.node.IDNode;
import gtna.routing.node.identifier.Identifier;

import java.util.HashMap;
import java.util.Random;

public class GreedyBacktracking extends RoutingAlgorithmImpl implements
		RoutingAlgorithm {
	private int ttl;

	public GreedyBacktracking(int ttl) {
		super("GREEDY_BACKTRACKING", new String[] { "TTL" }, new String[] { ""
				+ ttl });
		this.ttl = ttl;
	}

	public boolean applicable(Node[] nodes) {
		return nodes[0] instanceof IDNode;
	}

	public void init(Node[] nodes) {
		return;
	}

	public Route randomRoute(Node[] nodes, Node src, Random rand) {
		IDNode SRC = (IDNode) src;
		Identifier DEST = ((IDNode) nodes[rand.nextInt(nodes.length)])
				.randomID(rand, nodes);
		while (SRC.contains(DEST)) {
			DEST = ((IDNode) nodes[rand.nextInt(nodes.length)]).randomID(rand,
					nodes);
		}
		HashMap<IDNode, IDNode> pred = new HashMap<IDNode, IDNode>();
		return route(SRC, SRC, DEST, 0, pred, new RouteImpl());
	}

	public Route route(IDNode src, IDNode current, Identifier dest, int ttl,
			HashMap<IDNode, IDNode> pred, Route route) {
		route.add((Node)current);
		if (current.contains(dest)) {
			route.setSuccess(true);
			return route;
		}
		if (ttl >= this.ttl) {
			route.setSuccess(false);
			return route;
		}

		Node[] out = current.out();
		double minDist = current.dist(dest);
		IDNode nextHop = null;
		for (int i = 0; i < out.length; i++) {
			IDNode Out = (IDNode) out[i];
			double dist = Out.dist(dest);
			if (dist < minDist && !pred.containsKey(Out)
					&& !pred.containsValue(Out)) {
				minDist = dist;
				nextHop = Out;
			}
		}
		if (nextHop == null) {
			nextHop = pred.get(current);
		} else {
			pred.put(nextHop, current);
		}
		if (nextHop == null) {
			route.setSuccess(false);
			return route;
		}
		route.incMessages();
		return route(src, nextHop, dest, ttl + 1, pred, route);
	}
}
