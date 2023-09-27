package com.davidlopez.superheros_dls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.davidlopez.superheros_dls.model.HeroesRepository
import com.davidlopez.superheros_dls.ui.theme.Superheros_DLSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Superheros_DLSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun SuperHeroesPreview() {
        Superheros_DLSTheme {
            SuperheroesApp()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SuperheroesApp() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar()
            }
        ) {
            val heroes = HeroesRepository.heroes
            HeroesList(heroes = heroes, contentPadding = it)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.top_bar),
                    style = MaterialTheme.typography.displayLarge,
                )
            },
            modifier = modifier
        )
    }
}