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
 * Exploring.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 *
 * Original Author: Tim;
 * Contributors:    -;
 *
 * Changes since 2011-05-17
 * ---------------------------------------
 *
 */
package gtna;

import gtna.data.Series;
import gtna.drawing.Gephi;
import gtna.graph.Graph;
import gtna.id.IdentifierSpace;
import gtna.io.graphWriter.GtnaGraphWriter;
import gtna.metric.centrality.PageRank;
import gtna.metrics.Metric;
<<<<<<< HEAD
<<<<<<< HEAD
import gtna.metrics.basic.Assortativity;
import gtna.metrics.basic.ClusteringCoefficient;
import gtna.metrics.basic.DegreeDistribution;
import gtna.metrics.basic.ShortestPaths;
import gtna.networks.Network;
import gtna.networks.model.ZhouMondragon;
=======
import gtna.metrics.centrality.BetweennessCentrality;
import gtna.networks.Network;
import gtna.networks.model.Regular;
>>>>>>> bugfix bc (1)
=======
import gtna.networks.Network;
<<<<<<< HEAD
import gtna.networks.model.ErdosRenyi;
>>>>>>> calculate prVector
=======
import gtna.networks.model.BarabasiAlbert;
import gtna.networks.model.WattsStrogatz;
>>>>>>> fully functional implementation of the PageRank metric. ToDo: normalization of PageRank (prVector)
import gtna.plot.Plotting;
import gtna.transformation.Transformation;
import gtna.transformation.id.ConsecutiveRingIDSpace;
import gtna.transformation.id.RandomPlaneIDSpaceSimple;
import gtna.transformation.id.RandomRingIDSpaceSimple;
import gtna.util.Config;
import gtna.util.Stats;

/**
 * @author Tim
 * 
 */

public class Exploring {
	public static void main(String[] args) {
		Config.overwrite("SKIP_EXISTING_DATA_FOLDERS", "false");
		// Config.overwrite("GNUPLOT_PRINT_ERRORS", "true");
		
		
		boolean get = false; // get or generate
		int times = 2;		// how many generations?
		boolean b = false; // bidirectional
		
		

<<<<<<< HEAD
		boolean r = true;
		
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		Network nw0 = new ZhouMondragon(1000, 0.25, null);
=======
		Network nw0 = new ZhouMondragon(10000, 0.25, 2, null);
>>>>>>> debugged rich-club generator.
		
=======
		Network nw0 = new BarabasiAlbert(10000, 5, null);
>>>>>>> debugged calculation of the assortativity coefficient
		
<<<<<<< HEAD
		Network[] n = new Network[] {nw0};
=======
		boolean r = false;
		
		Network nw0 = new Regular(100, 1, r, b, null);
		Network nw1 = new Regular(200, 4, r, b, null);
		Network nw2 = new Regular(300, 4, r, b, null);
		Network nw3 = new Regular(400, 4, r, b, null);
		Network nw4 = new Regular(500, 4, r, b, null);
		Network nw5 = new Regular(600, 4, r, b, null);
		Network nw6 = new Regular(700, 4, r, b, null);
		Network nw7 = new Regular(800, 4, r, b, null);
		Network nw8 = new Regular(900, 4, r, b, null);
		Network nw9 = new Regular(1000, 4, r, b, null);
>>>>>>> debugging bc (2)
		
		Metric[] metrics = new Metric[] { 
<<<<<<< HEAD
				new Assortativity()
=======
		Network[] n = new Network[] {nw0 /*, nw1, nw2, nw3, nw4, nw5, nw6, nw7, nw8, nw9*/};
		
		Metric[] metrics = new Metric[] { 
				new BetweennessCentrality()
>>>>>>> bugfix bc (1)
=======
		Network nw0 = new ErdosRenyi(10000, 5, false, null);
=======
		Network nw0 = new ErdosRenyi(20, 5, false, null);
>>>>>>> calculate prVector
=======
		Network nw0 = new ErdosRenyi(200, 5, false, null);
>>>>>>> debugging plotting of page rank metric
		Network nw1 = new ErdosRenyi(20000, 5, false, null);
		Network nw2 = new ErdosRenyi(50000, 5, false, null);
		Network nw3 = new ErdosRenyi(100000, 5, false, null);
=======
		Network nw0 = new WattsStrogatz(4000, 5, 0.001, null);
		Network nw1 = new WattsStrogatz(4000, 5, 0.003, null);
		Network nw2 = new WattsStrogatz(4000, 5, 0.006, null);
		Network nw3 = new WattsStrogatz(4000, 5, 0.009, null);
>>>>>>> fully functional implementation of the PageRank metric. ToDo: normalization of PageRank (prVector)
		
		Network[] n = new Network[] {nw0, nw1, nw2, nw3};
		
		Metric[] metrics = new Metric[] { 
<<<<<<< HEAD
				new Assortativity(0)
				, new ClusteringCoefficient()
>>>>>>> complete implementation: Assortativity coefficient (Newman, 2002, Assortative Mixing in Networks)
=======
			new PageRank()
>>>>>>> calculate prVector
				};
=======
				new DegreeDistribution() };
>>>>>>> debugged rich-club generator.
		
		
		Series[] s = get ? Series.get(n, metrics) : Series.generate(n, metrics, times);
		
		Plotting.single(s, metrics, "example-s/");
//
		Plotting.multi(s, metrics, "example-m/");
<<<<<<< HEAD
//		
		
=======
		 
		/*
>>>>>>> complete implementation: Assortativity coefficient (Newman, 2002, Assortative Mixing in Networks)
		 for(Network i : n){
			 System.out.println("Plotting network - " + i.getKey() + " @ " + i.getNodes() + " nodes");
			 plot(i, "./plots/network-plot/n-"+i.getKey() + "-" + i.getNodes(), times);
		 }
		 */
		
	}
	
	
	public static void plot(Network nw, String filename, int times) {
		Transformation t_rpid = new RandomPlaneIDSpaceSimple(1, 100, 100, true);
		Transformation t_rrid = new RandomRingIDSpaceSimple(true);
		Transformation t_crid = new ConsecutiveRingIDSpace(true);
		
		Transformation t_nid = t_crid;
		
		
		for (int i = 0; i < times; i++) {
			Gephi gephi = new Gephi();
			if(t_nid == t_rpid){
				Config.overwrite("GEPHI_RING_RADIUS", "1");
				Config.overwrite("GEPHI_NODE_BORDER_WIDTH", "0.01");
				Config.overwrite("GEPHI_EDGE_SCALE", "0.001");
				Config.overwrite("GEPHI_DRAW_CURVED_EDGES", "false");
				Config.overwrite("GEPHI_NODE_SIZE", "0.1");
			}else 
				if(t_nid == t_rrid || t_nid == t_crid){
					Config.overwrite("GEPHI_RING_RADIUS", "50");
					Config.overwrite("GEPHI_NODE_BORDER_WIDTH", "0.01");
					Config.overwrite("GEPHI_EDGE_SCALE", "0.001");
					Config.overwrite("GEPHI_DRAW_CURVED_EDGES", "false");
					Config.overwrite("GEPHI_NODE_SIZE", "0.001");	
			}

			String graphFilename = filename;
			
			Graph g = nw.generate();
			
			g = t_nid.transform(g);
	
			IdentifierSpace ids = (IdentifierSpace) g
					.getProperty("ID_SPACE_0");
	
			new GtnaGraphWriter().writeWithProperties(g, graphFilename+".txt");
			
			gephi.plot(g, ids, graphFilename+".pdf");
			
			System.out.println(filename);
		}
	}
}
