package model

import "gopkg.in/mgo.v2/bson"

//Driver represents a music Driver
type Driver struct {
 ID     bson.ObjectId `bson:"_id"`
 City  City        `json:"city"`
 Fname string        `json:"fname"`
 Lname string        `json:"lname"`
 Username string        `json:"username"`
 Password string        `json:"password"`
 Email string        `json:"email"`
 LastLocationLat	float32	`json:"last_location_lat"`
 LastLocationLon	float32	`json:"last_location_lon"`
 Address string        `json:"address"`
 Phone string        `json:"phone"`
 Active   int32         `json:"active"`
}

//Drivers is an array of Driver
type Drivers []Driver