package model

import (
	"time"
	"gopkg.in/mgo.v2/bson"
)

// HasDriverState Entity
type HasDriverState struct {
 ID     bson.ObjectId `bson:"_id"`
 Driver Driver        `json:"driver"`
 Car Car        `json:"car"`
 DriverState	DriverState        `json:"driver_state"`
 CreationDate time.Time        `json:"creationDate"`
}

// HasDriverStates is an array of HasDriverState
type HasDriverStates []HasDriverState