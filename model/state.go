package model

import "gopkg.in/mgo.v2/bson"

//State Entity
type State struct {
 ID     bson.ObjectId `bson:"_id"`
 Country  Country        `json:"country"`
 Name string        `json:"name"`
 Abbreviation string        `json:"abbreviation"`
}

//States is an array of State
type States []State