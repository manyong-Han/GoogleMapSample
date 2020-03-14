package com.manyong.googlemapsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(37.5562349,126.9709912);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("서울역");
        markerOptions.snippet("지하철역");
        markerOptions.position(location);

        googleMap.addMarker(markerOptions);

        // 바로 좌표 잡아서 이동
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

        // 카메라가 이동하는듯한 모션을 준다
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}
