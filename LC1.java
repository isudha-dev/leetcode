package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[] {2,2,2,3,3,7,9,9,9,9,9,9,9,9,9,9,12,12,12,12,13,14,17,17,17,18,18,20,20,20,20,20,20,21,22,22,22,22,23,23,24,24,27,27,27,27,28,28,28,28,33,33,33,35,38,38,38,39,39,39,39,39,40,40,41,43,43,44,47,47,47,47,51,51,51,52,53,54,54,54,56,56,56,56,56,56,57,58,59,59,59,61,62,63,64,64,65,66,67,67,67,70,70,70,70,70,71,71,71,73,73,73,73,74,75,75,75,76,76,77,78,78,79,81,81,81,82,83,83,84,84,84,84,84,86,88,89,89,89,89,91,91,92,92,92,93,93,94,95,95,96,97,99,102,102,102,104,105,107,108,108,108,109,109,110,110,113,115,117,117,117,118,119,121,121,122,123,124,125,125,125,126,126,127,127,128,129,129,130,130,131,131,131,131,132,132,132,132,133,133,136,137,138,138,139,141,142,144,144,147,147,147,147,148,148,149,150,150,150,150,150,151,151,152,152,152,152,153,154,155,155,156,157,158,158,158,158,159,159,160,160,161,162,163,163,164,164,166,167,167,168,168,169,169,171,172,173,173,173,174,174,175,177,177,177,178,178,178,180,180,182,182,184,184,184,185,185,186,187,188,189,190,190,190,191,191,191,191,191,192,192,193,193,193,193,194,194,194,196,196,197,197,197,197,197,198,198,200,200,201,202,202,203,203,204,205,205,206,206,207,208,211,212,213,213,215,216,216,216,216,216,217,217,217,217,219,220,221,221,221,222,223,224,224,225,227,228,229,229,230,230,231,231,232,235,236,236,239,239,241,241,241,242,242,242,243,244,245,245,246,247,248,248,248,250,250,250,251,252,255,255,255,256,256,257,258,258,258,258,259,259,260,260,260,260,261,263,264,264,268,269,270,270,271,271,271,272,272,276,277,278,280,280,280,281,282,282,284,288,288,289,290,290,290,290,291,291,291,292,293,293,296,296,296,297,297,297,297,299,299,301,301,301,302,303,304,305,305,305,305,305,305,305,306,306,306,307,308,308,308,309,309,310,311,311,312,314,316,317,318,318,318,320,320,322,323,323,324,324,324,324,324,325,326,326,326,327,327,328,328,328,328,329,329,330,330,330,331,333,333,333,335,335,335,336,337,337,338,338,338,339,340,340,341,341,342,342,347,348,348,348,348,348,349,349,350,350,351,351,352,353,353,354,354,354,355,355,356,357,358,359,361,361,362,362,363,364,366,367,367,368,368,369,369,370,371,371,371,371,371,371,372,375,376,376,376,378,378,379,380,381,381,383,386,386,387,387,387,388,388,389,390,390,391,391,393,393,395,396,397,397,397,397,398,398,398,399,399,399,400,400,401,401,401,404,404,404,404,405,406,407,408,409,410,410,410,412,413,413,414,414,415,416,416,416,418,419,419,419,421,422,423,423,424,425,425,425,426,426,427,427,429,429,429,429,430,430,430,430,431,431,432,432,433,434,434,436,436,437,438,438,440,440,441,441,441,442,442,443,444,444,446,446,447,447,447,447,448,448,449,450,451,451,451,452,452,452,452,455,455,455,456,456,457,458,458,459,459,459,460,462,464,466,466,467,467,467,468,469,470,470,472,472,472,473,473,474,474,475,476,476,477,477,478,478,480,481,481,482,482,483,484,484,485,485,485,486,487,487,489,489,489,492,492,493,493,494,494,495,496,496,498,498,498,499,499,500,501,501,502,502,502,503,504,504,504,504,508,508,508,509,509,510,510,510,511,513,513,513,515,515,516,519,519,520,520,521,521,521,524,526,527,528,529,529,530,530,531,532,533,533,534,534,534,534,535,537,538,538,538,539,539,539,539,540,541,541,541,542,542,543,543,544,545,546,547,549,552,555,555,557,558,558,559,559,560,562,565,565,565,566,567,567,568,569,570,572,572,573,573,574,577,577,578,578,579,580,580,581,583,583,584,586,586,586,586,586,587,587,587,588,588,588,588,590,592,592,592,592,592,592,592,592,592,593,593,594,601,602,602,603,604,605,606,606,607,607,608,608,609,609,610,611,612,612,613,614,615,615,615,617,617,617,618,618,618,620,621,621,623,624,625,625,626,626,629,631,631,632,634,634,634,636,637,639,639,639,640,640,641,643,644,645,648,648,648,650,651,652,652,653,653,654,654,655,656,656,657,658,659,661,661,661,661,662,662,662,663,663,663,664,665,666,666,667,668,670,670,670,673,673,673,676,676,678,680,680,680,680,681,682,682,683,683,685,686,688,690,691,691,691,694,695,695,695,696,697,697,697,697,698,698,698,699,701,701,703,704,705,706,707,708,708,708,708,710,711,711,712,712,713,716,716,718,719,719,721,722,722,724,724,725,726,727,728,728,733,733,733,736,737,737,737,738,738,738,739,739,742,743,744,745,746,746,747,747,750,752,752,752,753,753,753,754,754,754,755,756,756,757,758,758,758,759,760,760,761,761,762,763,763,763,763,763,764,764,765,765,765,766,766,767,767,769,770,771,771,772,772,772,773,773,774,774,775,775,777,778,778,778,778,780,780,781,781,781,781,783,783,784,785,786,787,789,789,789,790,790,790,791,791,792,794,795,798,798,798,800,800,800,801,801,802,803,804,804,804,805,806,807,809,810,810,811,811,812,812,815,815,815,815,816,816,817,818,821,822,823,825,826,826,826,826,827,827,828,829,829,829,829,830,830,831,831,832,832,832,832,833,836,836,836,837,837,838,838,838,839,840,841,845,846,846,846,846,847,848,848,848,848,848,848,850,851,851,852,852,853,853,855,856,857,857,858,858,860,861,861,862,862,862,864,865,866,867,867,868,869,869,871,872,873,873,873,874,874,874,874,875,876,876,876,877,879,879,879,879,880,880,882,883,883,885,887,888,888,889,890,893,894,896,897,898,898,899,900,901,902,903,903,903,903,905,906,906,909,909,909,909,909,912,912,914,915,915,917,917,918,918,918,919,919,919,919,922,923,925,925,926,930,930,930,930,931,931,933,935,936,937,939,939,939,939,940,942,942,942,944,945,945,946,946,947,947,948,950,950,951,951,953,953,954,954,955,956,957,957,957,959,959,959,959,959,960,960,961,961,963,965,965,965,965,967,968,968,970,970,970,970,970,971,973,973,975,975,975,976,976,976,976,976,977,977,978,978,979,979,979,980,980,982,982,983,983,984,984,984,985,987,987,987,988,989,989,990,990,990,990,991,991,992,993,993,993,994,995,996,996,997,997,997,999,1000}, 28)).forEach(System.out::println);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i<nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key) && map.get(key) != i) {
                return new int[] {i, map.get(key)};
            }
        }

        return new int[2];
    }
}
