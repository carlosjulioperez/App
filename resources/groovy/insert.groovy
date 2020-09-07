/**
    This groovy script will take a CSV file that represents the data 
    in a database. The first row should be the name of the columns and
    all other rows should represent the data you wish to insert.
    The #generate_insert function also assumes that the csv file has the 
    same name as the sql table that is being inserted into
*/

//baseFile = "C:\\file\\path"

// Setup basic information
baseFile = "../sql/"
def generate_insert(tableName) {
    fileName = baseFile + tableName + ".csv"
    new File(fileName).splitEachLine(',') { fields ->
        if(i++ == 0) {
            // Pull columns from first row in CSV file
            columns = "(${fields.join(',')})"
        } else {
            // Pull each row of data and print an insert statement
            values = fields.collect { it.equals("sysdate") ? it : ("'" + it + "'") }
            println "INSERT INTO ${tableName}${columns} VALUES (${values.join(',')});"
        }
    }
}

generate_insert("DB29179_CIE10")
//generate_insert("another_table_name")
