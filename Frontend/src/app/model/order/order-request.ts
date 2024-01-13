export class OrderRequest {
    dateOrder: string | undefined;
    priceOrder: number = 0;
    taxPriceOrder: number = 0;
    totalPriceOrder: number = 0;
    voucherOrder: number = 0;
    productIds: number[] = [];
}
