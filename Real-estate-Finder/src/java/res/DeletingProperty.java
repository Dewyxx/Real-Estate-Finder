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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("delete")
public class DeletingProperty {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteProperty
     */
    public DeletingProperty() {
    }
    @Path("/removebyid") 
    @POST
    @Produces("text/html")
    public Response removeById(@FormParam("id") String id){
                JsonArray storeData=null ,filteredData=null;
                String fname = "JSON.txt"; 
                String output = "<font face='verdana' size='12'>" +
                "Real Estate Finder System"
                + "</font>";   
                storeData=TestMethod.readArray(fname);
                filteredData=TestMethod.delPropertyByID(storeData,id);
                TestMethod.persist(filteredData, fname);
                String fileData =TestMethod.tellMeAbout(filteredData);
                output = output+ "<h1>Deleted All Properties with id "+id+"</h1>"
                       + "<table border=\"1\"> <thead><tr><th>id</th><th>name</th>"
                       + "<th>price</th><th>typeofproperty</th><th>location</th><th>size</th>"
                       + "<th>yearbuilt</th> </tr></thead> <tbody>" 
                       +fileData
                       +"</tbody> </table></body></html>";
                 return Response.status(200).entity(output).build();
  }

    /**
     * Retrieves representation of an instance of res.DeleteProperty
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DeleteProperty
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
