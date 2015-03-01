package ir.webutils;

import java.util.*;
import java.net.*;
import java.io.*;
import ir.utilities.*;


public class PageRank {
	private String folderName = null;

	public PageRank(String folderName) {
		this.folderName = folderName;
	}

	public static void normalize(double[] x) {
		double length = MoreMath.vectorOneNorm(x);
		for(int i = 0; i < x.length; i++) {
			x[i] = x[i]/length;
		}
        }

	public void rank(Graph graph, double alpha, int iterations) {
		Node[] nodes = graph.nodeArray();
		HashMap indexMap = new HashMap((int) 1.4 * nodes.length);
		double[] r = new double[nodes.length];
		double[] rslash = new double[nodes.length];
		double[] e = new double[nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			indexMap.put(nodes[i].toString(), new Integer(i));
			r[i] = 1.0 / nodes.length;
			e[i] = alpha / nodes.length;
		}
		for (int j = 0; j < iterations; j++) {
			for (int i = 0; i < nodes.length; i++) {
				List inNodes = nodes[i].getEdgesIn();
				rslash[i] = 0;
				for (int k = 0; k < inNodes.size(); k++) {
					Node inNode = (Node) inNodes.get(k);
					String inName = inNode.toString();
					int fanOut = inNode.getEdgesOut().size();
					rslash[i] = rslash[i] + r[((Integer) indexMap.get(inName)).intValue()]/ fanOut;
				}
				rslash[i] = rslash[i] + e[i];
			}
			for (int i = 0; i < r.length; i++)
				r[i] = rslash[i];
			normalize(r);
		}
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter(folderName + "/page-ranks.txt"));
			for (int i = 0; i < nodes.length; i++){
				if(nodes[i].toString() != null) { 
				out.println(nodes[i].toString() + " " + r[i]);
				}			
			}
			
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}

