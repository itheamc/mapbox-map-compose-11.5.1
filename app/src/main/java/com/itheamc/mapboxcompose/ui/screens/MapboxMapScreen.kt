package com.itheamc.mapboxcompose.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mapbox.geojson.Point
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.MapViewportState
import com.mapbox.maps.extension.compose.rememberMapState

@OptIn(MapboxExperimental::class)
@Composable
fun MapboxMapScreen(
    modifier: Modifier = Modifier
) {

    val mapState = rememberMapState()
    val context = LocalContext.current

    MapboxMap(
        modifier = modifier,
        mapState = mapState,
        mapViewportState = MapViewportState().apply {
            setCameraOptions {
                zoom(10.0)
                center(Point.fromLngLat(85.10, 27.5))
                pitch(0.0)
                bearing(0.0)
            }
        },
        onMapClickListener = { point ->
            Toast.makeText(context, point.toString(), Toast.LENGTH_SHORT).show()
            true
        },

        onMapLongClickListener = { point ->
            Toast.makeText(context, point.toString(), Toast.LENGTH_SHORT).show()
            true
        }
    )

}