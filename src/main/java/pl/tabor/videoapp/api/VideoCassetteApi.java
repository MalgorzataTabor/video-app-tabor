package pl.tabor.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tabor.videoapp.dao.entity.VideoCassette;
import pl.tabor.videoapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {


    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @PostMapping
    public VideoCassette addCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.saveVideo(videoCassette);
    }

    //nadpisywanie elementów
    @PutMapping
    public VideoCassette updateCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.saveVideo(videoCassette);
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {

        return videoCassettes.findAll();

    }

    @DeleteMapping
    public void deleteCassette(@RequestParam Long index) {
         videoCassettes.deleteById(index);
    }


    @GetMapping
    public Optional<VideoCassette> findById(@RequestParam Long index){
        return videoCassettes.findById(index);
    }
}
