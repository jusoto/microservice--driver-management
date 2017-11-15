package model

import "gopkg.in/mgo.v2/bson"

// Country Entity
type Country struct {
 ID     bson.ObjectId `bson:"_id"`
 Name string        `json:"name"`

}

// Countries is an array of Country
type Countries []Country