import { Category } from "../category/category";
import { Inventory } from "../inventory/inventory";

export class Product {
    titleProduct: string | undefined;
    priceProduct: number | undefined;
    descriptionProduct: string | undefined;
    category: Category | undefined;
    inventory: Inventory | undefined;
    idOrders: number[] | undefined;

}
