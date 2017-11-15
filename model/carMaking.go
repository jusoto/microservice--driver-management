package model

import "gopkg.in/mgo.v2/bson"

// CarMaking Entity
type CarMaking struct {
 ID     bson.ObjectId `bson:"_id"`
 Name  string        `json:"name"`
}

// CarMakings is an array of CarMaking
type CarMakings []CarMaking