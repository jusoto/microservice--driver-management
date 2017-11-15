package model

import "gopkg.in/mgo.v2/bson"

// CarModel Entity representation
type CarModel struct {
 ID     bson.ObjectId `bson:"_id"`
 CarMaking  CarMaking        `json:"car_making"`
 Name string        `json:"name"`
}

// CarModels is an array of CarModel
type CarModels []CarModel