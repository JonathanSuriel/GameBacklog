package com.example.jonat.gamebacklog

import android.arch.persistence.room.TypeConverter

import java.util.Date


class Converters {
 companion object {
     @TypeConverter
     @JvmStatic
     fun statusToString(status: Status?): String {
         return status.toString()
     }

     @TypeConverter
     @JvmStatic
     fun stringtoStatus(status: String): Status? {
        return Status.valueOf(status)

     }
 }


}