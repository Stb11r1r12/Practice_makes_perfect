import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Categories } from "../categories/categories.component";

@Injectable( {providedIn: 'root'})
export class CategoryService{
    private url = "http://localhost:8080/categories";
    constructor(private http:HttpClient){};
    getCategories(){
        return this.http
        .get<Array<Categories>>(this.url,{
            headers: {
              'Access-Control-Allow-Origin': '*'
            }
          })
    }
    createCategory(category: Categories | undefined){
        const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
        return this.http.post<Categories>(this.url + "/create", JSON.stringify(category), {headers: myHeaders}); 
    }
    updateCategory(category: Categories | undefined) {
        const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
        return this.http.put<Categories>(this.url + "/update/" + category?.id, JSON.stringify(category), {headers:myHeaders});
    }
    deleteCategory(id: string | unknown){
     
        return this.http.delete<Categories>(this.url + '/delete/' + id,{
            headers: {
              'Access-Control-Allow-Origin': '*'
            }
          });
    }
}