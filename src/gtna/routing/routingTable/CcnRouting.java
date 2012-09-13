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
 * CcnRouting.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: benni;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna.routing.routingTable;

import gtna.graph.Graph;
import gtna.id.Identifier;
import gtna.routing.Route;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author benni
 * 
 */
@SuppressWarnings("rawtypes")
public class CcnRouting extends RoutingTableRouting {
	public CcnRouting() {
		super("CCN_ROUTING");
	}

	// @Override
	// public void preprocess(Graph graph) {
	// super.preprocess(graph);
	// this.dataStorageList = new DataStorageList(this.dataStorageList);
	// }

	@Override
	public Route routeToTarget(Graph graph, int start, Identifier target,
			Random rand) {
		Route route = this.routeToTarget(new ArrayList<Integer>(), start,
				target, graph.getNodes());
		if (route.isSuccessful()) {
			for (int node : route.getRoute()) {
				this.dataStorageList.getStorageForNode(node).add(target);
			}
		}
		return route;
	}
}