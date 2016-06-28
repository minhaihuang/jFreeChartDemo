package com.hhm.jFreeChart.test;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;


public class JFreeChartDemo {

	public static void main(String[] args) {
		// 1 准备数据模型,用来管理和存放数据

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(12, "中国", "北京");
		dataset.addValue(8, "中国", "上海");
		dataset.addValue(5, "中国", "深圳");

		dataset.addValue(10, "美国", "纽约");
		dataset.addValue(5, "美国", "洛杉矶");
		dataset.addValue(3, "美国", "西雅图");

		// 2 创建图表对象
		JFreeChart chart = ChartFactory.createBarChart3D("各单位柱状图", // 图表的标题
				"单位", // x轴标签
				"人数", // y轴标签
				dataset,// 数据模型
				PlotOrientation.VERTICAL, // 图表的方向
				true,// 是否显示图例
				true,// 是否显示工具提示
				true// 是否生成url链接
				);

		// 3设置样式
		Font titleFont = new Font("宋体", Font.BOLD, 18);
		Font labelFont = new Font("宋体", Font.PLAIN, 16);
		// 字体
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(titleFont);

		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(labelFont);

		// 绘图区域
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		// x轴对象
		CategoryAxis3D x = (CategoryAxis3D) plot.getDomainAxis();
		x.setLabelFont(labelFont);
		x.setTickLabelFont(labelFont);

		// y轴对象
		NumberAxis3D y = (NumberAxis3D) plot.getRangeAxis();
		y.setLabelFont(labelFont);

		// 着色区域对象
		BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
		// 显示柱子标签
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

		// 设置柱子的最大宽度
		renderer.setMaximumBarWidth(0.07);

		// 4 生效 : 把图表显示出来
		ChartFrame chartFrame = new ChartFrame("", chart);
		chartFrame.setVisible(true);
		chartFrame.pack();

	}
}
