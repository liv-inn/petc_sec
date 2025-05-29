function StatsCard({ title, value, icon }) {
  return (
    <div className="bg-white w-84 h-30 border border-gray-200  rounded-lg flex items-center justify-between px-6 py-2">

      <div className="flex flex-col justify-center gap-2">
        <span className="text-sm text-gray-500">{title}</span>
        <p className="text-2xl font-bold text-gray-800">{value}</p>
      </div>

      <div className="text-5xl text-blue-600">{icon}</div>
    </div>
  );
}
export default StatsCard;
