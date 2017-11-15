package driver

import (
 "fmt"
 "log"

 "gopkg.in/mgo.v2"
 "gopkg.in/mgo.v2/bson"
)

//Repository ...
type Repository struct{}

// SERVER the DB server
const SERVER = "localhost:27017"

// DBNAME the name of the DB instance
const DBNAME = "musicstore"

// DOCNAME the name of the document
const DOCNAME = "drivers"

// GetDrivers returns the list of Drivers
func (r Repository) GetDrivers() Drivers {
 session, err := mgo.Dial(SERVER)
 if err != nil {
  fmt.Println("Failed to establish connection to Mongo server:", err)
 }
 defer session.Close()
 c := session.DB(DBNAME).C(DOCNAME)
 results := Drivers{}
 if err := c.Find(nil).All(&results); err != nil {
  fmt.Println("Failed to write results:", err)
 }

return results
}

// AddDriver inserts an Driver in the DB
func (r Repository) AddDriver(driver Driver) bool {
 session, err := mgo.Dial(SERVER)
 defer session.Close()

driver.ID = bson.NewObjectId()
 session.DB(DBNAME).C(DOCNAME).Insert(driver)

if err != nil {
  log.Fatal(err)
  return false
 }
 return true
}

// UpdateDriver updates an Driver in the DB (not used for now)
func (r Repository) UpdateDriver(driver Driver) bool {
 session, err := mgo.Dial(SERVER)
 defer session.Close()

driver.ID = bson.NewObjectId()
 session.DB(DBNAME).C(DOCNAME).UpdateId(driver.ID, driver)

if err != nil {
  log.Fatal(err)
  return false
 }
 return true
}

// DeleteDriver deletes an Driver (not used for now)
func (r Repository) DeleteDriver(id string) string {
 session, err := mgo.Dial(SERVER)
 defer session.Close()

// Verify id is ObjectId, otherwise bail
 if !bson.IsObjectIdHex(id) {
  return "NOT FOUND"
 }

// Grab id
 oid := bson.ObjectIdHex(id)

// Remove user
 if err = session.DB(DBNAME).C(DOCNAME).RemoveId(oid); err != nil {
  log.Fatal(err)
  return "INTERNAL ERR"
 }

// Write status
 return "OK"
}