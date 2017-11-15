package model

import "gopkg.in/mgo.v2/bson"

// Car Entity
type Car struct {
	ID     bson.ObjectId `bson:"_id"`
	State  string        `json:"state"`
	Driver string        `json:"driver"`
	CarModel string        `json:"car_model"`
	Plate string        `json:"plate"`
	Password string        `json:"password"`
	ImageUri string        `json:"image_uri"`
	Year   int32         `json:"year"`
}

// Cars is an array of Car
type Cars []Car