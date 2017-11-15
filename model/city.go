package model

import "gopkg.in/mgo.v2/bson"

// City Entity
type City struct {
 ID     bson.ObjectId `bson:"_id"`
 State  State        `json:"state"`
 Name string        `json:"name"`
}

// Cities is an array of City
type Cities []City