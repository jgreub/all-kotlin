package com.jgreubel.allkotlin.fruit

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fruit")
class FruitController {

    val fruits: MutableList<Fruit> = mutableListOf()

    @GetMapping
    fun getAll(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) color: String?
    ): List<Fruit> {
        var result: List<Fruit> = fruits
        result = if (name != null) result.filter { it.name == name } else result
        result = if (color != null) result.filter { it.color == color } else result
        return result
    }

    @GetMapping("/{name}")
    fun getByName(@PathVariable name: String): Fruit? {
        return fruits.find { it.name == name }
    }

    @PostMapping
    fun create(@RequestBody fruit: Fruit) {
        fruits.add(fruit)
    }

}