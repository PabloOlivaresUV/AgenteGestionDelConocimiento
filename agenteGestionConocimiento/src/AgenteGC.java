/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteGC extends Agent{

    protected void setup(){
        System.out.println("My name local is "+getLocalName());
        System.out.println("“My GUID is "+getAID().getName());
        
        System.out.println("Agregando behaviour... Es un comportamiento de ejecución cíclica");
        addBehaviour(new AtenderConsultas(this));
        
    }
    
    class AtenderConsultas extends CyclicBehaviour{
          
        AtenderConsultas(Agent a){
            super(a);
        }
        
        
        public void action(){
                        
            ACLMessage msg = myAgent.receive();
            
            //En el caso que el mensaje sea válido...
            if(msg!=null){
                
                //Si se está consultando por la marca del producto
                if(msg.getContent().equals("proyecto1")){
                    ACLMessage reply;
                    
                    System.out.println("---------------------------------------");
                    System.out.println("NUEVA Consulta Recibida...");
                    System.out.println("Mensaje enviado por: "+ msg.getSender().getName());
                    System.out.println("ID de conversación: "+ msg.getConversationId());
                    System.out.println("Performativa: "+msg.getPerformative());
                    System.out.println("Contenido del mensaje: "+msg.getContent());            

                    //Preparando respuesta...
                    reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(msg.getSender());
                    reply.setConversationId(msg.getConversationId());
                    reply.setPerformative(msg.getPerformative());
                    reply.setContent("Este proyecto contiene brechas, se gestiona reunión. \nEnviando Correo...");
                    send(reply);
                   
                    System.out.println("\nMensaje de respuesta enviado a: "+msg.getSender().getName());                    
                    System.out.println("Quien preguntó por: "+msg.getContent());
                    System.out.println("La respuesta es: "+reply.getContent());
                    System.out.println("---------------------------------------\n");

                    
                  
                //Si se está consultando por el modelo del producto    
                }else if(msg.getContent().equals("proyecto2")){
                    ACLMessage reply;
                    
                    System.out.println("---------------------------------------");
                    System.out.println("NUEVA Consulta Recibida...");
                    System.out.println("Mensaje enviado por: "+ msg.getSender().getName());
                    System.out.println("ID de conversación: "+ msg.getConversationId());
                    System.out.println("Performativa: "+msg.getPerformative());
                    System.out.println("Contenido del mensaje: "+msg.getContent());             

                    //Preparando respuesta...
                    reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(msg.getSender());
                    reply.setConversationId(msg.getConversationId());
                    reply.setPerformative(msg.getPerformative());
                    reply.setContent("Entregando datos del proyecto... \nDiseño , \nDocumentación , \nHitos , \nDatos de contactos...");
                    send(reply);
 
                    System.out.println("\nMensaje de respuesta enviado a: "+msg.getSender().getName());                
                    System.out.println("Quien preguntó por: "+msg.getContent());
                    System.out.println("La respuesta es: "+reply.getContent());
                    System.out.println("---------------------------------------\n");                  
                    
                //Si se está solicitando el precio del producto...    
                }else if(msg.getContent().equals("proyecto3")){
                    ACLMessage reply;
                    
                    System.out.println("---------------------------------------");
                    System.out.println("NUEVA Consulta Recibida...");
                    System.out.println("Mensaje enviado por: "+ msg.getSender().getName());
                    System.out.println("ID de conversación: "+ msg.getConversationId());
                    System.out.println("Performativa: "+msg.getPerformative());
                    System.out.println("Contenido del mensaje: "+msg.getContent());             

                    //Preparando respuesta...
                    reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(msg.getSender());
                    reply.setConversationId(msg.getConversationId());
                    reply.setPerformative(msg.getPerformative());
                    reply.setContent("El usuario no posee todos los accecsos a los recursos para el proyecto...\nSe envían los acceso al correo coporativo... \nsend...");
                    send(reply);
                    
                    System.out.println("\nMensaje de respuesta enviado a: "+msg.getSender().getName());          
                    System.out.println("Quien preguntó por: "+msg.getContent());
                    System.out.println("La respuesta es: "+reply.getContent());
                    System.out.println("---------------------------------------\n");                   
                    
                //Si se está consultando por la garantía del producto
                }else if(msg.getContent().equals("proyecto4")){
                    ACLMessage reply;
                    
                    System.out.println("---------------------------------------");
                    System.out.println("NUEVA Consulta Recibida...");
                    System.out.println("Mensaje enviado por: "+ msg.getSender().getName());
                    System.out.println("ID de conversación: "+ msg.getConversationId());
                    System.out.println("Performativa: "+msg.getPerformative());
                    System.out.println("Contenido del mensaje: "+msg.getContent());            

                    //Preparando respuesta...
                    reply = new ACLMessage(ACLMessage.INFORM);
                    reply.addReceiver(msg.getSender());
                    reply.setConversationId(msg.getConversationId());
                    reply.setPerformative(msg.getPerformative());
                    reply.setContent("El usuario contiene todos los accecsos a los recursos para el proyecto...");
                    send(reply);
                    
                    System.out.println("\nMensaje de respuesta enviado a: "+msg.getSender().getName());          
                    System.out.println("Quien preguntó por: "+msg.getContent());
                    System.out.println("La respuesta es: "+reply.getContent());
                    System.out.println("---------------------------------------\n");

                }
                
                //blockingReceive(); 
            
            }
        
        }
    
    }
}
