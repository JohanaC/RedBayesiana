/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabayesianas;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

import org.openmarkov.core.exception.InvalidStateException;
import org.openmarkov.core.inference.InferenceAlgorithm;
import org.openmarkov.core.model.graph.Graph;
import org.openmarkov.core.model.network.EvidenceCase;
import org.openmarkov.core.model.network.Finding;
import org.openmarkov.core.model.network.ProbNet;
import org.openmarkov.core.model.network.ProbNode;
import org.openmarkov.core.model.network.Util;
import org.openmarkov.core.model.network.Variable;
import org.openmarkov.core.model.network.potential.TablePotential;
import org.openmarkov.inference.variableElimination.VariableElimination;
import org.openmarkov.io.probmodel.PGMXReader;

/**
 *
 * @author Edgar
 */
public class PruebaBayesianas {
    final private String bayesNetworkName = "BN-two-diseases.pgmx";

    // método queme devuelve los nodos de la red baesiana
    public List<modelo> obtenerNodos(String ruta) {
        List<modelo> nodos= new ArrayList<modelo>();
        
        try {
            // Open the file containing the network
            InputStream file = new FileInputStream(new File(ruta));

            // Load the Bayesian network
            PGMXReader pgmxReader = new PGMXReader();
            ProbNet probNet = pgmxReader.loadProbNet(file, bayesNetworkName).getProbNet();

            List<ProbNode> listPro = probNet.getProbNodes();
            //List<String> nodos= new ArrayList<String>();
           for (int i = 0; i < listPro.size(); i++) {
               modelo nd = new modelo();
                ProbNode probNode = listPro.get(i);
                nd.setNombre(probNode.getName());
                nd.setResul(probNode.getProbNet());
              
                nodos.add(nd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo elegido no es valido");
        }
        return nodos;
         
    }
    
    //Método para devolver información de un nodo especifico
    public TablePotential informacion(String nodo, String ruta){
        TablePotential in = null;
        try {
            // Open the file containing the network
            InputStream file = new FileInputStream(new File(ruta));

            // Load the Bayesian network
            PGMXReader pgmxReader = new PGMXReader();
            ProbNet probNet = pgmxReader.loadProbNet(file, bayesNetworkName).getProbNet();         
            List<ProbNode> listPro = probNet.getProbNodes();
           for (int i = 0; i < listPro.size(); i++) {
               ProbNode probNode = listPro.get(i);
               if(probNode.getName().equals(nodo)){
                   in = probNode.getUtilityFunction();                  
                   break;
               }

            }
           //return nodos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo elegido no es valido....\ndebe elgir un archivo con extensión  .pgmx");
        }
        return in;
         
    }
    ///METODO PARA DEVOLVER INFORMACION DEL NODO SELECCIONADO.
     public ProbNode devInf(String nodo, String ruta){
        ProbNode in = null;
        try {
            // abro el archivo en donde esta mi red
            InputStream file = new FileInputStream(new File(ruta));

            // cargo la red bayesiana
            PGMXReader pgmxReader = new PGMXReader();
            ProbNet probNet = pgmxReader.loadProbNet(file, bayesNetworkName).getProbNet();         
            List<ProbNode> listPro = probNet.getProbNodes();
           for (int i = 0; i < listPro.size(); i++) {
               ProbNode probNode = listPro.get(i);
               if(probNode.getName().equals(nodo)){
                   in=probNode;
                   break;
               }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo elegido no es valido....\ndebe elgir un archivo con extensión  .pgmx");
        }
        return in;
         
    }
     
     ///METODO PARA DEVOLVER INFORMACION DEL NODO SELECCIONADO.
     public double relevancia(String nodo, String ruta){
        double in = 0.0;
        try {
            // abro el archivo en donde esta mi red
            InputStream file = new FileInputStream(new File(ruta));

            // cargo la red bayesiana
            PGMXReader pgmxReader = new PGMXReader();
            ProbNet probNet = pgmxReader.loadProbNet(file, bayesNetworkName).getProbNet();         
            List<ProbNode> listPro = probNet.getProbNodes();
           for (int i = 0; i < listPro.size(); i++) {
               ProbNode probNode = listPro.get(i);
               if(probNode.getName().equals(nodo)){
                   in=probNode.getRelevance();
                   break;
               }

            }
           //return nodos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo elegido no es valido....\ndebe elgir un archivo con extensión  .pgmx");
        }
        return in;
         
    }
}