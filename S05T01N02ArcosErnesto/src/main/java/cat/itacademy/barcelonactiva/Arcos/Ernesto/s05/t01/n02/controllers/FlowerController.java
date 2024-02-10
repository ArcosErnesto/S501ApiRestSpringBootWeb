package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.FlowerDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.service.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Flower API", description = "Flower API Rest CRUD with MySQL v1")
@RestController
@RequestMapping("/api/v1/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @Operation(
            summary = "Create a Flower",
            description = "This endpoint allows adding a new flower to the database. The request body is expected to contain the details of the flower to be added in the FlowerDTO format. The operation returns the newly added flower with updated information, including the unique identifier assigned by the database.",
            tags = {"add"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Flower added successfully", content = {
                    @Content(schema = @Schema(implementation = FlowerDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "409", description = "Error in the request format.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = { @Content(schema = @Schema()) })
    })
    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> add(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO newBranch = flowerService.add(flowerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBranch);
    }

    @Operation(
            summary = "Update an existing flower in the database",
            description = "This endpoint allows updating the details of an existing flower in the database. The 'id' path parameter is expected to indicate the unique identifier of the flower to be updated. The request body must contain the new details of the flower in the FlowerDTO format. The operation returns the updated flower with the updated information.",
            tags = { "update" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flower.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "No flower found with the received ID.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "409", description = "Flower ID cannot be empty.", content = { @Content(schema = @Schema()) })
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<FlowerDTO>> update(@PathVariable int id, @RequestBody FlowerDTO flowerDTO){
        Optional<FlowerDTO>  updatedBranch= flowerService.update(id, flowerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedBranch);
    }

    @Operation(
            summary = "Delete flower by ID",
            description = "This endpoint allows deleting an existing flower from the database using its unique identifier. The 'id' path parameter is expected to indicate the unique identifier of the flower to be deleted. The operation returns a message indicating the result of the deletion.",
            tags = { "delete" })
    @ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "No flower found with the received ID.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable int id) {
        String msg = flowerService.delete(id);
        return ResponseEntity.ok(msg);
    }

    @Operation(
            summary = "Get a flower by ID",
            description = "This endpoint allows retrieving the details of an existing flower from the database using its unique identifier. The 'id' path parameter is expected to indicate the unique identifier of the flower to be retrieved. The operation returns the requested flower or a message indicating that the flower was not found.",
            tags = { "getOne" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flower.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "No flower found with the received ID.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "409", description = "Flower ID cannot be empty.", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Flower> getOneBranch(@PathVariable int id) {
        Optional<Flower> flower = flowerService.getOne(id);
        return flower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Get all flowers from the database",
            description = "This endpoint returns a list with all the flowers stored in the database. No additional parameters are required. The operation returns a list of FlowerDTO objects representing each flower.",
            tags = { "getAll" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flower.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> list() {
        List<FlowerDTO> flowers = flowerService.findAll();
        return ResponseEntity.ok(flowers);
    }
}
