package com.authoritydmc.learn.Resources.api.v1;


import com.authoritydmc.learn.Entity.User;
import com.authoritydmc.learn.Services.UserService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

import static com.authoritydmc.learn.configs.TAGS.UsersResourceTag;

@RestController
@Tag(name = UsersResourceTag)
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;


    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @ApiResponses(value = {
           @ApiResponse(responseCode = "200",description = "Got the list of users",content = {
                   @Content(mediaType = "application/json",schema = @Schema(implementation = User.class))
           }),

            @ApiResponse(responseCode = "404",description = "Unable to fetch list of users",content = @Content)
    })
@Operation(summary = "Get Users",description = "Get list of users ",tags = UsersResourceTag)
    @GetMapping("")
    public ResponseEntity<List<User>> Greet()
    {
        return ResponseEntity.ok(userService.getUsers());
    }


    @PostMapping("")
    @Operation(summary = "Add User",description = "Add a User in DB ",tags = UsersResourceTag)

    public ResponseEntity<Object> addUser(@RequestBody User user)
    {

        if (userService.insertUser(user)!=null)
        return ResponseEntity.status(201).body(user);
        else
          return   ResponseEntity.status(424).body("Can not create User as User with Such Id already Exist");

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update User",description = "Update a User in DB ",tags = UsersResourceTag)
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user)
    {
        User userFound=userService.updateuser(user,id);
        if (userFound==null)
            return ResponseEntity.status(404).body("User does not Exist");


        return  ResponseEntity.ok(userFound);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Update User",description = "Update a User in DB ",tags = UsersResourceTag)
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        boolean opsStatus=userService.deleteUser(id);
        if (opsStatus==false)
return ResponseEntity.status(404).body("User does not Exist");
        return  ResponseEntity.ok("Successfully deleted the User");
    }
}
