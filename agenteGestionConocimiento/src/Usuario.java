/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Usuario extends Agent {

    //String vendedorID;
    
    //public Cliente(String sellerID){
        //vendedorID = sellerID;
    //}
    
    protected void setup(){
        //System.out.println("My name local is "+getLocalName());
        //System.out.println("“My GUID is "+getAID().getName());
        
        //System.out.println("Agregando behaviour... Es un comportamiento de ejecución cíclica");
        addBehaviour(new ConsultarProductos(this));
        
    }
    
    

    
    class ConsultarProductos extends CyclicBehaviour{

        ConsultarProductos(Agent a){
            super(a);
        }
        
        public void action(){

            //doWait(5000);
            
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST); 
            msg.addReceiver(new AID ("AgenteGestionConocimiento", AID.ISLOCALNAME));
            msg.setConversationId("Consulta_proyecto_1_EnviaCorreo");
            msg.setPerformative(1);
            msg.setContent("proyecto1");  
            send(msg);
            //System.out.println("CLIENTE ENVIANDO MENSAJE A: ... "+"vendedor");
            
            blockingReceive();
            doWait(5000);
            
            msg = new ACLMessage(ACLMessage.REQUEST); 
            msg.addReceiver(new AID ("AgenteGestionConocimiento", AID.ISLOCALNAME));
            msg.setConversationId("Consulta_proyecto_2_NoEnviaCorreo");
            msg.setPerformative(1);
            msg.setContent("proyecto2");   
            send(msg);
            //System.out.println("CLIENTE ENVIANDO MENSAJE A: ... "+"vendedor");
            
            blockingReceive();
            doWait(5000);
            
            msg = new ACLMessage(ACLMessage.REQUEST); 
            msg.addReceiver(new AID ("AgenteGestionConocimiento", AID.ISLOCALNAME));
            msg.setConversationId("Consulta_proyecto_3_EnviaAccesos");
            msg.setPerformative(1);
            msg.setContent("proyecto3");    
            send(msg);
            //System.out.println("CLIENTE ENVIANDO MENSAJE A: ... "+"vendedor");

            blockingReceive();
            doWait(5000);
            
            msg = new ACLMessage(ACLMessage.REQUEST); 
            msg.addReceiver(new AID ("AgenteGestionConocimiento", AID.ISLOCALNAME));
            msg.setConversationId("Consulta_proyecto_3_NoEnviaAccesos");
            msg.setPerformative(1);
            msg.setContent("proyecto4");  
            send(msg);
            //System.out.println("CLIENTE ENVIANDO MENSAJE A: ... "+"vendedor");            
            
            blockingReceive();    
            doWait(5000);
            

        } 

        
        
    }
}