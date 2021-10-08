/**
 * Charlie Melnarik
 */

data class City(val name: String, val latitude: Double, val longitude: Double)

fun listCities():List<City>{
    val city1 = City("Atlanta", 33.7490, -84.3880)
    val city2 = City("Bozeman", 45.6770, -111.0429)
    val city3 = City("New York", 40.7128, -74.0060)
    val city4 = City("San Francisco", 37.7749, -122.4194)
    val city5 = City("Tacoma", 47.2529, -122.4443)
    
    val citylist: MutableList<City> = mutableListOf(city1, city2, city3, city4, city5)
   
    return citylist
}

fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {    
    val R = 6372.8 // in kilometers    
    val l1 = Math.toRadians(lat1)    
    val l2 = Math.toRadians(lat2)    
    val dl = Math.toRadians(lat2 - lat1)    
    val dr = Math.toRadians(lon2 - lon1)    
    
    return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(dl / 2), 2.0) + Math.pow(Math.sin(dr / 2), 2.0) * Math.cos(l1) * Math.cos(l2)))}

fun distanceFromSeattle(city: City): Double{
    val Seattle = City("Seattle", 47.6062, -122.3321)
    var distance = haversine(Seattle.latitude, Seattle.longitude, city.latitude, city.longitude)
    
	return distance   
}

fun anonymous_function(city: City): Boolean{
	var distance = distanceFromSeattle(city)
    if (distance < 1000){
        return false
    }
    else{
        return true
    }
}


fun main(){
    println("***************Step Two****************")
	var cityLocations = listCities()
    cityLocations.forEach{
        cityLocations -> println(cityLocations)
    }
    
    println("***************Step Three****************")
    println("The distance between Seattle and Tacoma is ")
    var distance = distanceFromSeattle(City("Tacoma", 47.2529, -122.4443))
    print(distance)
    println(" km")
    
    println("***************Step Four****************")
    println("A new List with the distances of all cities in list to Seattle:")
    
    //correct way
	val mapped = cityLocations.map{x -> distanceFromSeattle(x)}
    println(mapped)
    
	    
   	// this does what it needs to do but isnt probably the correct way. If worse comes to worse
   	// use this 
    //cityLocations.forEach{
        //cityLocations -> println(distanceFromSeattle(cityLocations))
    //}
    
    
    
    println("***************Step Five****************")
    println("List of cities over 1000km from Seattle:")  
    
    val filtered = cityLocations.filter{x -> anonymous_function(x)}
    filtered.forEach{
        x -> println(x.name)
    }
    
    println("***************Step Six****************")
        
 	val step_six = cityLocations.filter{it.longitude < -89.97803}
    val part2 = step_six.map{it.name}
    println(part2)
    
    
    
    println("***************Step Seven****************")
    print("Max Distance: ")
    
    val max = cityLocations.maxBy{distanceFromSeattle(it)}
    println(max)
    
    println("***************Step Eight****************")
    
	var mappedCities: MutableMap<String, City> = mutableMapOf<String, City>()
    cityLocations.forEach{
        mappedCities.put(it.name, it)
    }
    mappedCities.forEach{
        x -> println("Name " + x)
    }

    if (mappedCities.containsKey("Bozeman")){
    	val bozeman = mappedCities.getValue("Bozeman")
    	println("The latitude for Bozeman is " + bozeman.latitude)
    }
    else{
        println("That city was not found ")
    }
}
