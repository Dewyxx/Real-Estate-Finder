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


@Path("/AddProperty")
public class AddingProperty {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AddProperty
     */
    public AddingProperty() {
    }
    @Path("/addProperty")
    @POST
    @Produces("text/html")
    public Response addProperty(@FormParam("id") String id,
                                @FormParam("name") String name,
                                @FormParam("price") String price,
                                @FormParam("typeofproperty")String typeofproperty,                                
                                @FormParam("location") String location,
                                @FormParam("size") String size,
                                @FormParam("yearbuilt") String yearbuilt) {
                String output = "<font fac=e='verdana' size='2'>" +
                "the new property added information with"
                + " id - <u>"+id+"</u>, name - <u>"+name+"</u>"
                + "price - <u>"+price+"</u></font>";   
       JsonArray newArr=null; JsonArray storeData=null;
       String fname = "JSON.txt"; 
       storeData=TestMethod.readArray(fname);       
       newArr=TestMethod.addJsonToArray(storeData,TestMethod.createproperty(id,name,price,typeofproperty,location,size,yearbuilt));
       TestMethod.persist(newArr, fname);
       String fileData =TestMethod.tellMeAbout(newArr);
       output = output+ "<h1>get data from jason</h1> <br>"
              +id +name +price +" :<br><br><p>list of property from array</p>"
              + fileData+"</body></html>";
        return Response.status(200).entity(output).build();
    }

    
    
    
    /**
     * Retrieves representation of an instance of res.AddProperty
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AddProperty
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
