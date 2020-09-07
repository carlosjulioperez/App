#!/bin/bash
# Bash Menu Script Example
# http://askubuntu.com/questions/1705/how-can-i-create-a-select-menu-in-a-shell-script

PS3='Input your option: '
options=("compile" "updateSchema" "updateClass" "deployWar" "delete-Db" "sql-import-h2" "sql-query" "test" "zip" "Quit")

select opt in "${options[@]}"
do
    case $opt in
        "delete-Db")
			ant delete-Db
            ;;
        "compile")
            ant compile
            ;;
		"updateSchema")
			ant updateSchema
			;;
		"updateClass")
			ant updateClass
			;;
		"deployWar")
            # ant deployWar
			mvn war:war
			#ln -s /home/carper/43/App/target/App /home/carper/local/openxava-4.3/tomcat/webapps
            ln -s /home/knoppix/local/openxava-4.3/workspace/App/target/App /home/knoppix/tomcat/webapps

			#ln -s ~/local/projects/App/target/App ~/local/openxava-4.3/tomcat/webapps
			;;
		"sql-import-h2")
			ant sql-import-h2
			;;
		"sql-query")
			ant sql-query
			;;
		"test")
			ant test
			;;
		"zip")
			ant zip
			;;
		"Quit")
            break
            ;;
        *) echo invalid option;;
    esac
done
