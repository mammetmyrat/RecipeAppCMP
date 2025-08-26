package com.mammet.recipeapp.features.common.data.database

import com.mammet.recipeapp.Recipe
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

fun recipeEntityMapper(
    recipe: Recipe
) =  RecipeItem (
    id = recipe.id,
    title = recipe.title,
    description = recipe.description,
    category = recipe.category,
    area = recipe.area,
    imageUrl = recipe.imageUrl,
    youtubeLink = recipe.youtubeLink,
    ingredients = recipe.ingredients,
    instructions = recipe.instructions,
    isFavorite = recipe.isFavorite == 1L,
    rating = recipe.rating,
    duration = recipe.duration ?: "20 Min",
    difficulty = recipe.difficulty ?: "Easy"

)