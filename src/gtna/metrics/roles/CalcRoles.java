/*
 * ===========================================================
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
 * CalcRoles.java
 * ---------------------------------------
 * (C) Copyright 2009-2011, by Benjamin Schiller (P2P, TU Darmstadt)
 * and Contributors 
 * 
 * Original Author: Benjamin Schiller;
 * Contributors:    -;
 * 
 * Changes since 2011-05-17
 * ---------------------------------------
 */
package gtna.metrics.roles;


/**
 * @deprecated
 */
// TODO reimplement CalcRoles
public class CalcRoles {

	// //create GeneralGraphMethods object
	//
	// @SuppressWarnings("unchecked")
	// //define global private variables
	// private ArrayList<ArrayList<Integer>> roles;
	//
	// //constructor
	// public CalcRoles(int[] nlist, Group[] glist, Graph g){
	// CatalogRoleIdent(nlist, glist, g);
	// }
	//
	// //identify the role for each node
	// private ArrayList<ArrayList<Integer>> CatalogRoleIdent(int[] nlist,
	// Group[] glist, Graph g) {
	// // create the groups
	// roles = new ArrayList<ArrayList<Integer>>();
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	// roles.add(new ArrayList<Integer>());
	//
	// double P, z;
	// int dest_group = -1;
	//
	// // go through all the groups and assign roles to all the nodes
	// for(int i=0; i < glist.length; i++){
	// for(int j=0; j < glist[i].getNodeList().size(); j++){
	// //calculate participation coefficient for given node
	// P = ParticipationCoefficient(glist[i].getNodeList().get(j), nlist, glist,
	// g);
	// //calculate z-score for given node
	// z = WithinModuleRelativeDegree(glist[i].getNodeList().get(j), nlist,
	// glist, g);
	//
	// if(z < 2.5){ // Node is not a Hub
	// if(P < 0.05)
	// dest_group = 0; //ultra-peripheral - nodes with all their links within
	// their own module
	// else if(P < 0.62)
	// dest_group = 1; //peripheral nodes - nodes with most links within their
	// module
	// else if(P < 0.8)
	// dest_group = 2; //Satellite connector - Node with a high fraction of
	// their links to other modules
	// else
	// dest_group = 3; //kinless node - Node with links homogeneously
	// distributed among all modules
	// }else{ // Node is a Hub
	// if(P < 0.3)
	// dest_group = 4; //Provincial hub - hub with the vast majority of links
	// with in their module
	// else if(P < 0.75)
	// dest_group = 5; //connector hub - hub with many links to most of the
	// other modules
	// else
	// dest_group = 6; //global hub - hub with links homogeneously distributed
	// among all modules
	// }
	// // Add (softly) the node to the role group
	// roles.get(dest_group).add(glist[i].getNodeList().get(j));
	// }
	// }
	//
	// //debug print
	// System.out.println("");
	// String[] names = new String[7];
	// names[0] = "Ultra-Peripheral";
	// names[1] = "Peripheral Nodes";
	// names[2] = "Satellite Connector";
	// names[3] = "Kinless Node";
	// names[4] = "Provincial Hub";
	// names[5] = "Connector Hub";
	// names[6] = "Global Hub";
	// for(int i=0; i < 7; i++){
	// System.out.println(names[i]+": "+roles.get(i).toString());
	// }
	// System.out.println("\n");
	// return roles;
	// }
	//
	// @SuppressWarnings("unchecked")
	// //getter method
	// public ArrayList<ArrayList<Integer>> getRoles(){
	// return this.roles;
	// }
	//
	// // calculate the within-module relative degree of a node. The network
	// // must be properly mapped to the partition under consideration.
	// private double WithinModuleRelativeDegree(int node, int[] nlist, Group[]
	// glist, Graph g) {
	// int inDegree;
	// double kmean = 0.0, k2mean = 0.0, kstd, z;
	// Group group = glist[nlist[node]];
	// ArrayList<Integer> nodeList = group.getNodeList();
	//
	// // go through all the nodes in the group and calculate mean and
	// // standard deviation of the within-module degrees
	//
	// for(int i=0; i < nodeList.size(); i++){
	// inDegree = GeneralGraphMethods.NLinksToGroup(nodeList.get(i), group, g,
	// nlist);
	// kmean += (double)inDegree;
	// k2mean += (double)inDegree * (double)inDegree;
	// }
	// kmean /= (double)group.getNodeList().size();
	// k2mean /= (double)group.getNodeList().size();
	// kstd = Math.sqrt(k2mean - kmean * kmean);
	//
	// // calculate the z-score
	// if(kstd == 0.0)
	// z = 0.0;
	// else
	// z = ((double) GeneralGraphMethods.NLinksToGroup(node, group, g, nlist) -
	// kmean) / kstd;
	//
	// return z;
	// }
	//
	// // Calculate the participation coefficient of a node
	// private double ParticipationCoefficient(int node, int[] nlist, Group[]
	// glist, Graph g) {
	// int toGroup;
	// double P = 0.0;
	// int nlink = GeneralGraphMethods.degreeOfNode(node, g);
	// // HashSet<Integer> neighbours = ;
	//
	// if(nlink !=0){
	// for(Integer index: GeneralGraphMethods.neighborsOfNode(node, g)){
	// toGroup = GeneralGraphMethods.NLinksToGroup(node, glist[nlist[index]], g,
	// nlist);
	// P += (double)toGroup / (double)(nlink * nlink);
	// }
	// P = 1.0 - P;
	// }
	//
	// return P;
	// }
}
