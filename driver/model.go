package driver

import "gopkg.in/mgo.v2/bson"

//Driver represents a music driver
type Driver struct {
 ID     bson.ObjectId `bson:"_id"`
 Title  string        `json:"title"`
 Artist string        `json:"artist"`
 Year   int32         `json:"year"`
}

//Drivers is an array of Driver
type Drivers []Driver