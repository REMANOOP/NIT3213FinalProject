package com.example.nit3213project.ui.details

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nit3213project.model.Entity
import com.example.nit3213project.R

class DetailsActivity : AppCompatActivity() {
    private lateinit var artistNameTextView: TextView
    private lateinit var albumTitleTextView: TextView
    private lateinit var releaseYearTextView: TextView
    private lateinit var genreTextView: TextView
    private lateinit var trackCountTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var popularTrackTextView: TextView
    private lateinit var entityImageView: ImageView // New ImageView for the entity image
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize the Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show the back button
        supportActionBar?.setDisplayShowTitleEnabled(false) // Remove the title

        // Initialize the TextViews and ImageView
        artistNameTextView = findViewById(R.id.artistNameTextView)
        albumTitleTextView = findViewById(R.id.albumTitleTextView)
        releaseYearTextView = findViewById(R.id.releaseYearTextView)
        genreTextView = findViewById(R.id.genreTextView)
        trackCountTextView = findViewById(R.id.trackCountTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        popularTrackTextView = findViewById(R.id.popularTrackTextView)
        entityImageView = findViewById(R.id.entityImageView) // Initialize the ImageView

        // Retrieve the Entity object from the intent
        val entity: Entity? = intent.getParcelableExtra("ENTITY")

        // Use the entity data to populate your views
        entity?.let {
            artistNameTextView.text = "Artist: ${it.artistName}"
            albumTitleTextView.text = "Album: ${it.albumTitle}"
            releaseYearTextView.text = "Release Year: ${it.releaseYear}"
            genreTextView.text = "Genre: ${it.genre}"
            trackCountTextView.text = "Track Count: ${it.trackCount}"
            descriptionTextView.text = "Description: ${it.description}"
            popularTrackTextView.text = "Popular Track: ${it.popularTrack}"
            entityImageView.setImageResource(it.imageResId) // Set the image resource for the entity
        }
    }

    // Handle the back button action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Close this activity and return to the previous one
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
