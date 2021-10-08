// Charlie Melnarik
package main

import (
//      "bufio"
        "fmt"
        "io"
//      "io/ioutil"
        "os"
        "bufio"
//      "unicode"
        "regexp"
        "strings"
)


func check(e error){
        if e != nil{
                panic(e)
        }
}

func open(file string)([]string, error){

        f, err := os.Open(file)
        check(err)
        var puff []string
        buff := bufio.NewScanner(f)
        for buff.Scan(){
                puff = append(puff, buff.Text())
        }

        return puff, buff.Err()
}

func parse(file []string)(string) {

        result := strings.Join(file, "")
        reg, err := regexp.Compile("[^a-zA-z]+")
        check(err)
        prostring := reg.ReplaceAllString(result, "")

        return prostring

}

func write(file string) {

//      fmt.Printf("%s\n", file)

        fmt.Println("Enter file name to call new file ")
        var output string
        fmt.Scanln(&output)

        f, err := os.Create(output)
        check(err)
        _, err = io.WriteString(f, file)
        check(err)
}


func main() {
        fmt.Println("Enter file name to read from ")
        var input string
        fmt.Scanln(&input)

        buff, err := open(input)
        check(err)
        parse(buff)
        done := parse(buff)
        write(done)
}
