package com.hhm.jFreeChart.test;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;



/**
 * 绘制扇形图
 * @author 黄帅哥
 *
 */
public class Test03PieChart {

	public static void main(String[] args) {
		
		//准备数据
		DefaultPieDataset dataset=new DefaultPieDataset();
		dataset.setValue("北京", 12);
		dataset.setValue("上海", 8);
		dataset.setValue("深圳", 5);
		
		//准备报表对象
		JFreeChart chart=ChartFactory.createPieChart3D(
				"扇形表",
				dataset,
				true,
				true,
				true
				);
		
		
		//设置样式
		Font titleFont=new Font("宋体", Font.BOLD, 18);
		Font labelFont=new Font("宋体", Font.BOLD, 15);
		
		//设置标题字体
		TextTitle textTitle=chart.getTitle();
		textTitle.setFont(titleFont);
		
		//设置标签字体
		LegendTitle legendTitle=chart.getLegend();//获取图例
		legendTitle.setItemFont(labelFont);
		
		//设置绘图区域的字体
		PiePlot3D plot=(PiePlot3D) chart.getPlot();
		plot.setLabelFont(labelFont);
		
		// 设置标签样式
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1}人{2}"));
		
		//显示图标
		ChartFrame frame=new ChartFrame("haha", chart);
		frame.setVisible(true);//窗口可见
		frame.pack();//图形可见
		}
	
	
	
	public static void test(){
		// 1 准备数据
				DefaultPieDataset dataset = new DefaultPieDataset();
				dataset.setValue("北京", 12);
				dataset.setValue("上海", 8);
				dataset.setValue("深圳", 5);

				// 2 创建图表
				JFreeChart chart = ChartFactory.createPieChart3D("各单位人数饼状图",// 主标题
						dataset,// 数据模型
						true,// 是否显示图例
						true,// 是否显示提示信息
						true);// 是否启用url功能

				// 3设置样式
				Font titleFont = new Font("宋体", Font.BOLD, 18);
				Font labelFont = new Font("宋体", Font.BOLD, 16);
				// 字体
				TextTitle textTitle = chart.getTitle();
				textTitle.setFont(titleFont);

				LegendTitle legendTitle = chart.getLegend();
				legendTitle.setItemFont(labelFont);

				// 绘图区域
				PiePlot3D plot = (PiePlot3D) chart.getPlot();
				plot.setLabelFont(labelFont);

				// 设置标签样式
				plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1}人{2}"));

				// 4 显示图表
				ChartFrame chartFrame = new ChartFrame("", chart);
				chartFrame.setVisible(true);
				chartFrame.pack();
	}
}
