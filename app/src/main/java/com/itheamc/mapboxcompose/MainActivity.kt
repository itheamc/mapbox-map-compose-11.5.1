package com.itheamc.mapboxcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.itheamc.mapboxcompose.ui.screens.MapboxMapViewScreen
import com.itheamc.mapboxcompose.ui.theme.MapboxComposeTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.animation.MapAnimationOptions
import com.mapbox.maps.plugin.animation.flyTo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapboxComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        MapboxMapViewScreen(
                            modifier = Modifier.weight(1f),
                            onMapCreated = { mapboxMap ->
                                lifecycleScope.launch {
                                    delay(5000)
                                    mapboxMap.loadStyle(Style.LIGHT) {
                                        mapboxMap.flyTo(
                                            cameraOptions = CameraOptions.Builder()
                                                .center(Point.fromLngLat(82.524441, 27.829059))
                                                .pitch(0.0)
                                                .zoom(10.0)
                                                .bearing(0.0)
                                                .build(),
                                            animationOptions = MapAnimationOptions.mapAnimationOptions {
                                                startDelay(1000)
                                                duration(1000)
                                            }

                                        )
                                    }

                                }
                            }
                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                        MapboxMapScreen(
//                            modifier = Modifier.weight(1f)
//                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapboxComposeTheme {

    }
}