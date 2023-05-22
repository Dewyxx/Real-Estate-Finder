/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import javax.json.JsonArray;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/ViewAll")
public class ViewingAll {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ViewingAll
     */
    public ViewingAll() {
    }
    
    @Path("/v") 
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getALLProperty() {
                JsonArray storeData=null;
                String fname = "JSON.txt"; 
                String output = "<font face='verdana' size='12'>" +
                "Real Estate Finder System"
                + "</font>";   
                storeData=TestMethod.readArray(fname);       
                String fileData =TestMethod.tellMeAbout(storeData);
                output = output+ "<h1>List All properties</h1>"
                       + "<table border=\"1\"> <thead><tr><th>id</th><th>name</th>"
                       + "<th>price</th><th>typeofproperty</th><th>location</th><th>size</th>"
                       + "<th>yearbuilt</th> </tr></thead> <tbody>" 
                       +fileData
                       +"</tbody> </table></body></html>";
                 return Response.status(200).entity(output).build();
  }

    
    

    /**
     * Retrieves representation of an instance of res.ViewAll
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @Path("/viewall")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllProperty(){
        String data="";
        return  data;
    }
    
    
    
    
    
    
    
    
    

    /**
     * PUT method for updating or creating an instance of ViewAll
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
