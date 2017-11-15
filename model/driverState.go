package model

import "gopkg.in/mgo.v2/bson"

//DriverState represents a music DriverState
type DriverState struct {
 ID     bson.ObjectId `bson:"_id"`
 Name string        `json:"name"`
 Description string        `json:"description"`
}

//DriverStates is an array of DriverState
type DriverStates []DriverState