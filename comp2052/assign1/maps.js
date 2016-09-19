var map;

function initialize(){
    map = new google.maps.Map(document.getElementById('map_canvas'), {
        zoom: 16,
        center: new google.maps.LatLng(49.251053, -123.002957),
    });
}

google.maps.event.addDomListener(window, 'load', initialize);

$("#bcit-campus").change(
    function(){
        var name = $('#bcit-campus option:selected').val();

        switch (name){
            case "burnaby":
                document.getElementById("campus-info").innerHTML ="<p>The <a href=" +'"' + "http://www.bcit.ca/about/burnaby.shtml" + '"' + ">BCIT Burnaby Campus</a> is located just off the Trans-Canada Highway at the corner of Willingdon Avenue and Canada Way." + "<br><br>" + "3700 Willingdon Avenue" + "<br>" + "Burnaby, BC" + "<br>" + "V5G 3H2, Canada</p> ";

                 map.setCenter(new google.maps.LatLng(49.251053,-123.002957));
               
                break;

            case "downtown":
                document.getElementById("campus-info").innerHTML ="<p>The <a href=" +'"' + "http://www.bcit.ca/about/downtown.shtml" + '"' + ">BCIT Downtown Campus</a> is in the heart of Vancouver, near the Granville Skytrain Station." + "<br><br>" + "555 Seymour Street" + "<br>" + "Vancouver, BC" + "<br>" + "V6B 3H6, Canada</p>";

                 map.setCenter(new google.maps.LatLng(49.283421,-123.115212));

                break;

            case "marine":
                document.getElementById("campus-info").innerHTML ="<p>The <a href=" +'"' + "http://www.bcit.ca/about/marine.shtml" + '"' + ">BCIT Marine Campus</a> is located in North Vancouver near the Lonsdale Quay and SeaBus terminal." + "<br><br>" + "265 West Esplanade" + "<br>" + "North Vancouver, BC" + "<br>" + "V7M 1A5, Canada</p>";

                 map.setCenter(new google.maps.LatLng(49.312901,-123.086112));

                break;

            case "aerospace":
                 document.getElementById("campus-info").innerHTML ="<p>The <a href=" +'"' + "http://www.bcit.ca/about/aerospace.shtml" + '"' + ">BCIT Aerospace Technology Campus</a> is in  Richmond near the South Terminal for the Vancouver International Airport." + "<br><br>" + "3800 Cessna Drive" + "<br>" + "Richmond, BC" + "<br>" + "V7B 0A1, Canada</p>";

                  map.setCenter(new google.maps.LatLng(49.184868,-123.144229));

                break;

            case "annacis":
                 document.getElementById("campus-info").innerHTML ="<p>The <a href=" +'"' + "http://www.bcit.ca/about/annacis.shtml" + '"' + ">BCIT Annacis Island Campus</a> is located in Delta." + "<br><br>" + "1608 Cliveden Avenue" + "<br>" + "Delta, BC" + "<br>" + "V3M 6M2, Canada</p>";

                  map.setCenter(new google.maps.LatLng(49.163609,-122.969765));

                break;

            default:
                //empty
        }
    }
);