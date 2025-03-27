name="heima"
stock_price=19.99
stock_code="003032"
stock_price_daily_growth_factor=1.2
growth_days=7
current_price=stock_price*(stock_price_daily_growth_factor**growth_days)
print(f"公司名：{name}，股票代码：{stock_code}，当前股价：{stock_price}")
print("每日增长系数：%.1f"%stock_price_daily_growth_factor,"经过:%d天增长" %growth_days,"股票达到了:%5.2f"%current_price)