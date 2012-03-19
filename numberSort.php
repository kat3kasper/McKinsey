<?PHP

$arr = array(1,2,2,2,3,3,3,3,3,4,4,4,4);
$sortedArray = sortArray($arr);
foreach($sortedArray as $k=>$elem)
	echo("$k ");

function sortArray($arr)
{
	$countArr = array_count_values($arr);
	arsort($countArr);
	return $countArr;
}

?>