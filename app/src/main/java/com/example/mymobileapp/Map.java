package com.example.mymobileapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymobileapp.databinding.ActivityMapsBinding;

public class Map extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private double latitude;
    private double longitude;
    private String title;

    private static final LatLng MANDARINA = new LatLng(6.900278217891883, 79.85362140996469);
    private static final LatLng MARINO = new LatLng(6.90030026765638, 79.85227075133206);
    private static final LatLng HILTON = new LatLng(6.932569662560563, 79.84477774595365);
    private static final LatLng MELHEIM = new LatLng(6.757071124603963, 80.92721918200311);
    private static final LatLng BLACKWOOD = new LatLng(6.762088196238136, 80.9285605423277);
    private static final LatLng GOLDEN_ROCK = new LatLng(6.872014937315219, 81.05641665316756);
    private static final LatLng LE_GRAND_GALLE = new LatLng(6.032124664735708, 80.21239952437926);
    private static final LatLng HOTEL_BRIXIA = new LatLng(6.035512636127916, 80.21580481083546);
    private static final LatLng ELLIOT_NATURE = new LatLng(6.044863025207587, 80.21605438385244);
    private static final LatLng MOKSHA_KITHULGALA = new LatLng(7.017845834135578, 80.415731768513);
    private static final LatLng CENTAURIA_RESORT= new LatLng(6.320146940836527, 80.85611429734537);
    private static final LatLng HOTEL_ELEPHANT_PARK= new LatLng(7.300605104667797, 80.38451993240108);
    private static final LatLng ANANTAYA_RESTORT= new LatLng(7.64121972805616, 79.80154612618912);

    private static final LatLng CLUB_HOTEL_DOLPHIN= new LatLng(7.293785773725747, 79.8395504752612);
    private static final LatLng BLUE_AND_GREEN= new LatLng(7.394620373878678, 79.82062396851522);
    private static final LatLng JETWING= new LatLng(9.661405368840484, 80.0168843472466);
    private static final LatLng NORTH_GATE = new LatLng(9.664494441470193, 80.0205857944558);
    private static final LatLng REECH_MULLAI = new LatLng(9.57772507572448, 80.41178238465501);
    private static final LatLng SANCTUARY = new LatLng(8.344064142896194, 80.39164497185342);
    private static final LatLng EARL_RAJARATA = new LatLng(8.324362652357731, 80.38283929625756);
    private static final LatLng MIHISARA = new LatLng(8.30702202109654, 80.44062594367074);
    private static final LatLng KARPAHA_SANDS = new LatLng(7.872334017690396, 81.5669125484013);
    private static final LatLng AMARANTHE_BAY = new LatLng(8.618363593591845, 81.21543361414383);
    private static final LatLng EAST_LAGOON = new LatLng(7.728734033949289, 81.7049022040259);
    private static final LatLng THE_ARGYLE = new LatLng(6.917400344863156, 80.58666445254822);
    private static final LatLng MANDARAM_ECO = new LatLng(7.041066536843941, 80.75774034971063);
    private static final LatLng SERENDIP_STONE = new LatLng(7.276815136423386, 80.67634894125365);








    private static final String TITLE_MANDARINA = "Mandarina Hotel";
    private static final String TITLE_MARINO = "Marino Beach";
    private static final String TITLE_HILTON = "Hilton Colombo Hotel";
    private static final String TITLE_MELHEIM= "Melheim Hotel";
    private static final String TITLE_BLACKWOOD= "Blackwood Hotel";
    private static final String TITLE_GOLDEN_ROCK= "Golden Rock Hotel";
    private static final String TITLE_LE_GRAND_GALLE= "Le Grand Galle";
    private static final String TITLE_HOTEL_BRIXIA= "Hotel Brixia";
    private static final String TITLE_ELLIOT_NATURE= "Elliot Nature";
    private static final String TITLE_MOKSHA_KITHULGALA= "Moksha kithulgala";
    private static final String TITLE_CENTAURIA_RESORT= "Centauria Lake Resort";
    private static final String TITLE_HOTEL_ELEPHANT_PARK= "Hotel Elephant Park";
    private static final String TITLE_ANANTAYA_RESTORT= "Anantaya Resort";
    private static final String TITLE_CLUB_HOTEL_DOLPHIN= "Club Hotel Dolphin";
    private static final String TITLE_BLUE_AND_GREEN= "Blue and Green Resort";
    private static final String TITLE_JETWING= "Jetwing Mahesa Bhawan";
    private static final String TITLE_NORTH_GATE= "North Gate Hotel";
    private static final String TITLE_REECH_MULLAI= "Reecha Mullai Hotel";
    private static final String TITLE_SANCTUARY= "The Sanctuary Hotel";
    private static final String TITLE_EARL_RAJARATA= "Earl Rajarata";
    private static final String TITLE_MIHISARA= "Mihisara Resort";
    private static final String TITLE_KARPAHA_SANDS= "Karpaha Sands";
    private static final String TITLE_AMARANTHE_BAY= "Amaranthé Bay Resort";
    private static final String TITLE_EAST_LAGOON= "Hotel East Lagoon";
    private static final String TITLE_THE_ARGYLE= "The Argyle";
    private static final String TITLE_MANDARAM_ECO= "Mandaram Eco Resort";
    private static final String TITLE_SERENDIP_STONE= "Serendip Stone Bungalow & Hotel";

















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            latitude = extras.getDouble("latitude");
            longitude = extras.getDouble("longitude");
            title = extras.getString("title");
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng location;

        if (latitude != 0 && longitude != 0) {
            location = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(location).title(title));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18.0f));
        }


        mMap.addMarker(new MarkerOptions().position(MANDARINA).title(TITLE_MANDARINA));
        mMap.addMarker(new MarkerOptions().position(MARINO).title(TITLE_MARINO));
        mMap.addMarker(new MarkerOptions().position(HILTON).title(TITLE_HILTON));
        mMap.addMarker(new MarkerOptions().position(MELHEIM).title(TITLE_MELHEIM));
        mMap.addMarker(new MarkerOptions().position(BLACKWOOD).title(TITLE_BLACKWOOD));
        mMap.addMarker(new MarkerOptions().position(GOLDEN_ROCK).title(TITLE_GOLDEN_ROCK));
        mMap.addMarker(new MarkerOptions().position(LE_GRAND_GALLE).title(TITLE_LE_GRAND_GALLE));
        mMap.addMarker(new MarkerOptions().position(HOTEL_BRIXIA).title(TITLE_HOTEL_BRIXIA));
        mMap.addMarker(new MarkerOptions().position(ELLIOT_NATURE).title(TITLE_ELLIOT_NATURE));
        mMap.addMarker(new MarkerOptions().position(MOKSHA_KITHULGALA).title(TITLE_MOKSHA_KITHULGALA));
        mMap.addMarker(new MarkerOptions().position(CENTAURIA_RESORT).title(TITLE_CENTAURIA_RESORT));
        mMap.addMarker(new MarkerOptions().position(HOTEL_ELEPHANT_PARK).title(TITLE_HOTEL_ELEPHANT_PARK));
        mMap.addMarker(new MarkerOptions().position(ANANTAYA_RESTORT).title(TITLE_ANANTAYA_RESTORT));
        mMap.addMarker(new MarkerOptions().position(CLUB_HOTEL_DOLPHIN).title(TITLE_CLUB_HOTEL_DOLPHIN));
        mMap.addMarker(new MarkerOptions().position(BLUE_AND_GREEN).title(TITLE_BLUE_AND_GREEN));
        mMap.addMarker(new MarkerOptions().position(JETWING).title(TITLE_JETWING));
        mMap.addMarker(new MarkerOptions().position(NORTH_GATE).title(TITLE_NORTH_GATE));
        mMap.addMarker(new MarkerOptions().position(REECH_MULLAI).title(TITLE_REECH_MULLAI));
        mMap.addMarker(new MarkerOptions().position(SANCTUARY).title(TITLE_SANCTUARY));
        mMap.addMarker(new MarkerOptions().position(EARL_RAJARATA).title(TITLE_EARL_RAJARATA));
        mMap.addMarker(new MarkerOptions().position(MIHISARA).title(TITLE_MIHISARA));
        mMap.addMarker(new MarkerOptions().position(KARPAHA_SANDS).title(TITLE_KARPAHA_SANDS));
        mMap.addMarker(new MarkerOptions().position(AMARANTHE_BAY).title(TITLE_AMARANTHE_BAY));
        mMap.addMarker(new MarkerOptions().position(EAST_LAGOON).title(TITLE_EAST_LAGOON));
        mMap.addMarker(new MarkerOptions().position(THE_ARGYLE).title(TITLE_THE_ARGYLE));
        mMap.addMarker(new MarkerOptions().position(MANDARAM_ECO).title(TITLE_MANDARAM_ECO));
        mMap.addMarker(new MarkerOptions().position(SERENDIP_STONE).title(TITLE_SERENDIP_STONE));










        mMap.getUiSettings().setZoomControlsEnabled(true);



    }


}