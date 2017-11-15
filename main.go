package main

import (
	"github.com/AITestingOrg/microservice--driver-management/controller"
	"github.com/AITestingOrg/microservice--driver-management/repository"
	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
	"log"
	"net/http"
)

func main() {
	router := NewRouter() // create routes

	// these two lines are important in order to allow access from the front-end side to the methods
	allowedOrigins := handlers.AllowedOrigins([]string{"*"})
	allowedMethods := handlers.AllowedMethods([]string{"GET", "POST", "DELETE", "PUT"})

	// launch server with CORS validations
	log.Fatal(http.ListenAndServe(":9000",
		handlers.CORS(allowedOrigins, allowedMethods)(router)))
}

var driverController = &controller.DriverController{Repository: repository.DriverRepository{}}

// Route defines a route
type Route struct {
	Name        string
	Method      string
	Pattern     string
	HandlerFunc http.HandlerFunc
}

//Routes defines the list of routes of our API
type Routes []Route

var routes = Routes{
	Route{
		"Index",
		"GET",
		"/api/v1/drivers",
		driverController.Index,
	},
	Route{
		"AddDriver",
		"POST",
		"/api/v1/drivers",
		driverController.AddDriver,
	},
	Route{
		"UpdateDriver",
		"PUT",
		"/api/v1/drivers",
		driverController.UpdateDriver,
	},
	Route{
		"DeleteDriver",
		"DELETE",
		"/api/v1/drivers/{id}",
		driverController.DeleteDriver,
	},
}

//NewRouter configures a new router to the API
func NewRouter() *mux.Router {
	router := mux.NewRouter().StrictSlash(true)
	for _, route := range routes {
		var handler http.Handler
		handler = route.HandlerFunc
		//handler = logger.Logger(handler, route.Name)

		router.
			Methods(route.Method).
			Path(route.Pattern).
			Name(route.Name).
			Handler(handler)

	}
	return router
}
