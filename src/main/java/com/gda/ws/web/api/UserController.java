package com.gda.ws.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gda.ws.service.UserService;
import com.gda.ws.web.api.dto.UserDto;

/**
 * The UserController class is a RESTful web service controller. The <code>@RestController</code> annotation informs
 * Spring that each <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>.
 */
@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;


    /**
     * Web service endpoint to fetch all entities. The service returns the collection of entities as
     * JSON.
     * 
     * @return A ResponseEntity containing a Collection of objects.
     */
    @RequestMapping(value = "/api/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<UserDto>> getUsers() {
        LOG.info("> getUsers");
        Collection<UserDto> entities = service.findAll();
        LOG.info("< getUsers");
        return new ResponseEntity<Collection<UserDto>>(entities, HttpStatus.OK);
    }

    /**
     * <p>
     * Web service endpoint to fetch a single UserDto entity by primary key identifier.
     * </p>
     * <p>
     * If found, the UserDto is returned as JSON with HTTP status 200. If not found, the service returns an empty
     * response body with HTTP status 404.
     * </p>
     * 
     * @param id A Long URL path variable containing the UserDto primary key identifier.
     * @return A ResponseEntity containing a single UserDto object, if found, and a HTTP status code as described in
     *         the method comment.
     */
    @RequestMapping(value = "/api/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        LOG.info("> getUser");

        UserDto entity = service.findOne(id);
        if (entity == null) {
            LOG.info("< getUser");
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }

        LOG.info("< getUser");
        return new ResponseEntity<UserDto>(entity, HttpStatus.OK);
    }
    
    /**
     * <p>
     * Web service endpoint to fetch a single UserDto entity by device id.
     * </p>
     * <p>
     * If found, the UserDto is returned as JSON with HTTP status 200. If not found, the service returns an empty
     * response body with HTTP status 404.
     * </p>
     * 
     * @param id A Long URL path variable containing the UserDto device id.
     * @return A ResponseEntity containing a single UserDto object, if found, and a HTTP status code as described in
     *         the method comment.
     */
    @RequestMapping(value = "/api/users/device-id/{deviceId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserByDeviceId(@PathVariable String deviceId) {
        LOG.info("> getUser");

        UserDto entity = service.findByDeviceId(deviceId);
        if (entity == null) {
            LOG.info("< getUserByDeviceId");
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }

        LOG.info("< getUserByDeviceId");
        return new ResponseEntity<UserDto>(entity, HttpStatus.OK);
    }

    /**
     * <p>
     * Web service endpoint to create a single UserDto entity. The HTTP request body is expected to contain a UserDto
     * object in JSON format. The UserDto is persisted in the data repository.
     * </p>
     * <p>
     * If created successfully, the persisted UserDto is returned as JSON with HTTP status 201. If not created
     * successfully, the service returns an empty response body with HTTP status 500.
     * </p>
     * 
     * @param entity The UserDto object to be created.
     * @return A ResponseEntity containing a single UserDto object, if created successfully, and a HTTP status code as
     *         described in the method comment.
     */
    @RequestMapping(value = "/api/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto entity) {
        LOG.info("> createUser");
        UserDto saved = service.create(entity);
        LOG.info("< createUser");
        return new ResponseEntity<UserDto>(saved, HttpStatus.CREATED);
    }

    /**
     * <p>
     * Web service endpoint to update a single Greeting entity. The HTTP request body is expected to contain a Greeting
     * object in JSON format. The Greeting is updated in the data repository.
     * </p>
     * <p>
     * If updated successfully, the persisted Greeting is returned as JSON with HTTP status 200. If not found, the
     * service returns an empty response body and HTTP status 404. If not updated successfully, the service returns an
     * empty response body with HTTP status 500.
     * </p>
     * 
     * @param entity The Greeting object to be updated.
     * @return A ResponseEntity containing a single Greeting object, if updated successfully, and a HTTP status code as
     *         described in the method comment.
     */
    @RequestMapping(value = "/api/users/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") final Long id,
            @RequestBody UserDto entity) {
        LOG.info("> updateUser");
        entity.setId(id);
        UserDto updated = service.update(entity);
        LOG.info("< updateUser");
        return new ResponseEntity<UserDto>(updated, HttpStatus.OK);
    }

    /**
     * <p>
     * Web service endpoint to delete a single UserDto entity. The HTTP request body is empty. The primary key
     * identifier of the UserDto to be deleted is supplied in the URL as a path variable.
     * </p>
     * <p>
     * If deleted successfully, the service returns an empty response body with HTTP status 204. If not deleted
     * successfully, the service returns an empty response body with HTTP status 500.
     * </p>
     * 
     * @param id A Long URL path variable containing the UserDto primary key identifier.
     * @return A ResponseEntity with an empty response body and a HTTP status code as described in the method comment.
     */
    @RequestMapping(value = "/api/users/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") final Long id) {
        LOG.info("> deleteUser");
        service.delete(id);
        LOG.info("< deleteUser");
        return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
    }
}
