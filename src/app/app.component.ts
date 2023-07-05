import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { CategoryService } from './services/categoryService';
import { Categories } from './categories/categories.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //styleUrls: ['./app.component.css']
  providers: [CategoryService],
  
})
export class AppComponent implements OnInit{
  title = "angular-daybitel";
  @ViewChild('readOnlyTemplate', { static: false })
  readOnlyTemplate!: TemplateRef<any> | null;
  @ViewChild('editTemplate', { static: false })
  editTemplate!: TemplateRef<any> | null;

  editedCategory!: Categories;
  categories!: Array<Categories>;
  isNewRecord!: boolean;
  statusMessage!: string;

  constructor(private serv: CategoryService) {
    this.categories = new Array<Categories>()
  }

  ngOnInit() {
    this.loadCategories()
  }

  //загрузка 
  private loadCategories() {
    this.serv.getCategories().subscribe((data: Categories[]) => {
      this.categories = data;
    })
  }
  // добавление 
  addCategory() {
    this.editedCategory = new Categories('', true);
    this.categories.push(this.editedCategory);
    this.isNewRecord = true;
  }

  // редактирование 
  editCategory(category: Categories) {
    this.editedCategory = new Categories(category.name, category.type)
    this.editedCategory.id = category.id;
    //this.editTemplate?.createEmbeddedView()
    
    //this.editedCategory = new Categories('', true);
    //this.isNewRecord = false;
  }
  //загружаем один из двух шаблонов
  loadTemplate(category: Categories ) {
    //console.log("Templates");
    if ((this.editedCategory && this.editedCategory.id== category.id)) {
      //console.log("EditTemplate");
      return this.editTemplate;
    } else {
      //console.log("readTemplate");
      return this.readOnlyTemplate;
    }
  }
 
  // сохраняем 
  saveCategory() {
    if (this.isNewRecord) {
      // добавляем 
      this.serv
        .createCategory(this.editedCategory)
        .subscribe((data) => {
          ;(this.statusMessage =
            'Данные успешно добавлены'),
            this.loadCategories()
        })
      this.isNewRecord = false;
      
    } else {
      // изменяем 
      this.serv
        .updateCategory(this.editedCategory)
        .subscribe((data) => {
          ;(this.statusMessage =
            'Данные успешно обновлены'),
            this.loadCategories()
        })
    }
    //this.editCategory = null
  }
  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.categories.pop();
      this.isNewRecord = false;
    }
    //this.editedCategory = undefined;
  }
  // удаление 
  deleteCategory(category: Categories) {
    this.serv.deleteCategory(category.id).subscribe((data) => {
      (this.statusMessage = 'Данные успешно удалены'),
        this.loadCategories()
    })
  } 
}
