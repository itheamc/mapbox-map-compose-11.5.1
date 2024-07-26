package com.itheamc.mapboxcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style

@Composable
fun MapboxMapViewScreen(
    modifier: Modifier = Modifier,
    onMapCreated: (MapboxMap) -> Unit = {}
) {

    AndroidView(
        modifier = modifier,
        factory = { context ->
            MapView(
                context,
                mapInitOptions = MapInitOptions(context, styleUri = Style.SATELLITE)
            ).apply {
                onMapCreated.invoke(mapboxMap)
                mapboxMap.setCamera(
                    CameraOptions.Builder()
                        .center(Point.fromLngLat(85.10, 27.5))
                        .pitch(0.0)
                        .zoom(5.0)
                        .bearing(0.0)
                        .build()
                )
            }
        }
    )

}