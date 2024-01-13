import { Category } from "../category/category";

export class Product {
    titleProduct: string | undefined;
    priceProduct: number = 0;
    descriptionProduct: string | undefined;
    category: number | undefined;
    idOrders: number[] | undefined;

}
