package controller

import (
  "github.com/AITestingOrg/microservice--driver-management/repository"
  "github.com/AITestingOrg/microservice--driver-management/model"
 "encoding/json"
 "io"
 "io/ioutil"
 "log"
 "net/http"
 "strings"
 "github.com/gorilla/mux"
)

//Controller ...
type DriverController struct {
 Repository repository.DriverRepository
}

// Index GET /
func (c *DriverController) Index(w http.ResponseWriter, r *http.Request) {
 drivers := c.Repository.GetDrivers() // list of all drivers
 log.Println(drivers)
 data, _ := json.Marshal(drivers)
 w.Header().Set("Content-Type", "application/json; charset=UTF-8")
 w.Header().Set("Access-Control-Allow-Origin", "*")
 w.WriteHeader(http.StatusOK)
 w.Write(data)
 return
}

// AddDriver POST /
func (c *DriverController) AddDriver(w http.ResponseWriter, r *http.Request) {

var driver model.Driver
 body, err := ioutil.ReadAll(io.LimitReader(r.Body, 1048576)) // read the body of the request
 if err != nil {
  log.Fatalln("Error AddDriver", err)
  w.WriteHeader(http.StatusInternalServerError)
  return
 }
 if err := r.Body.Close(); err != nil {
  log.Fatalln("Error AddDriver", err)
 }
 if err := json.Unmarshal(body, &driver); err != nil { // unmarshall body contents as a type Candidate
  w.WriteHeader(422) // unprocessable entity
  if err := json.NewEncoder(w).Encode(err); err != nil {
   log.Fatalln("Error AddDriver unmarshalling data", err)
   w.WriteHeader(http.StatusInternalServerError)
   return
  }
 }
 success := c.Repository.AddDriver(driver) // adds the driver to the DB
 if !success {
  w.WriteHeader(http.StatusInternalServerError)
  return
 }

w.Header().Set("Content-Type", "application/json; charset=UTF-8")
 w.WriteHeader(http.StatusCreated)
 return
}

// UpdateDriver PUT /
func (c *DriverController) UpdateDriver(w http.ResponseWriter, r *http.Request) {
 var driver model.Driver
 body, err := ioutil.ReadAll(io.LimitReader(r.Body, 1048576)) // read the body of the request
 if err != nil {
  log.Fatalln("Error UpdateDriver", err)
  w.WriteHeader(http.StatusInternalServerError)
  return
 }
 if err := r.Body.Close(); err != nil {
  log.Fatalln("Error AddaUpdateDriverlbum", err)
 }
 if err := json.Unmarshal(body, &driver); err != nil { // unmarshall body contents as a type Candidate
  w.Header().Set("Content-Type", "application/json; charset=UTF-8")
  w.WriteHeader(422) // unprocessable entity
  if err := json.NewEncoder(w).Encode(err); err != nil {
   log.Fatalln("Error UpdateDriver unmarshalling data", err)
   w.WriteHeader(http.StatusInternalServerError)
   return
  }
 }

success := c.Repository.UpdateDriver(driver) // updates the driver in the DB
 if !success {
  w.WriteHeader(http.StatusInternalServerError)
  return
 }

w.Header().Set("Content-Type", "application/json; charset=UTF-8")
 w.Header().Set("Access-Control-Allow-Origin", "*")
 w.WriteHeader(http.StatusOK)
 return
}

// DeleteDriver DELETE /
func (c *DriverController) DeleteDriver(w http.ResponseWriter, r *http.Request) {
 vars := mux.Vars(r)
 id := vars["id"] // param id

if err := c.Repository.DeleteDriver(id); err != "" { // delete a driver by id
  if strings.Contains(err, "404") {
   w.WriteHeader(http.StatusNotFound)
  } else if strings.Contains(err, "500") {
   w.WriteHeader(http.StatusInternalServerError)
  }
  return
 }

w.Header().Set("Content-Type", "application/json; charset=UTF-8")
 w.Header().Set("Access-Control-Allow-Origin", "*")
 w.WriteHeader(http.StatusOK)

return
}