package com.hhm.jFreeChart.test;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Year;

/**
 * 线性图
 * @author 黄帅哥
 *
 */
public class Test02LinerChart {
	
	
	public static void main(String[] args) {
		//准备数据模型
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		//加入数据
		dataset.addValue(6, "北京", new Year(2013));
		dataset.addValue(10, "北京", new Year(2014));
		dataset.addValue(11, "北京", new Year(2015));

		dataset.addValue(12, "上海", new Year(2013));
		dataset.addValue(8, "上海", new Year(2014));
		dataset.addValue(9, "上海", new Year(2015));
		
		//准备图形对象
		JFreeChart chart=ChartFactory.createLineChart(
				"线型图", //标题
				"年份",//x轴
				"人数",//y轴valueAxisLabel
				dataset,//数据
				PlotOrientation.VERTICAL,//图形方向orientation
				true,//是否显示图形实例legend
				true,//是否显示图形工具tooltips
				true//是否生成图示链接urls
				);
		
		
		
		//设置样式
		//处理中文乱码
				Font titleFont=new Font("宋体", Font.BOLD, 18);//标题字体的样式
				Font labelFont=new Font("宋体", Font.BOLD, 15);//标签字体的样式
				
//				chart.getTitle().setFont(titleFont);//设置标题样式
//				
//				chart.getLegend().setItemFont(labelFont);//图示案例的字体
				
				// 字体
				TextTitle textTitle = chart.getTitle();
				textTitle.setFont(titleFont);

				LegendTitle legendTitle = chart.getLegend();
				legendTitle.setItemFont(labelFont);
				
				//获取绘画区域
				CategoryPlot plot=(CategoryPlot) chart.getPlot();
				
				//获取x轴对象
				CategoryAxis x=plot.getDomainAxis();
				x.setLabelFont(labelFont);//设置x轴标签字体
				x.setTickLabelFont(labelFont);//设置x轴刻度字体
				
				//获取y轴对象
				ValueAxis y=plot.getRangeAxis();
				y.setLabelFont(labelFont);//设置y轴字体
				
				//获取着色区域对象
				LineAndShapeRenderer renderer=(LineAndShapeRenderer) plot.getRenderer();
				// 显示连接点图标
				renderer.setBaseItemLabelsVisible(true);
				//在点上显示数字
				renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
				
				// 显示连接点形状
				renderer.setBaseShapesVisible(true);
		
		//让图形显示
		ChartFrame frame=new ChartFrame("", chart);
		frame.setVisible(true);//窗口可见
		frame.pack();//图形可见
	}
}
